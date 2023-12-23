package dp.괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class SystemReader {

  BufferedReader br;

  public SystemReader() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public int readlineToInteger() {
    try {
      int i = Integer.parseInt(br.readLine());
      return i;
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}

class Logic {

  ArrayList<BigInteger> factorials;
  ArrayList<BigInteger> possibles;

  public Logic() {
    initFactorials();
    initPossibles();
  }

  private void initFactorials() {
    factorials = new ArrayList<>();
    factorials.add(BigInteger.ZERO);
    factorials.add(BigInteger.ONE);
    IntStream.range(2, 5001).forEach((i) -> factorials.add(factorials.get(i - 1).multiply(BigInteger.valueOf(i))));
  }

  public static boolean isEven(Integer i) {
    return i % 2 == 0;
  }

  private void initPossibles() {
    possibles = new ArrayList<>();
    LongStream.range(0, 5001).forEach((i) -> possibles.add(BigInteger.valueOf(0)));
    IntStream.range(2, 5001).filter(Logic::isEven)
        .forEach((i) -> {
          possibles.set(i, factorials.get(i)
              .divide(factorials.get(i / 2))
              .divide(factorials.get((i / 2) + 1))
              .mod(BigInteger.valueOf(1000000007)));
        });
  }

  public BigInteger getPossible(int index) {
    return possibles.get(index);
  }
}

public class Main {

  public static void main(String args[]) {
    SystemReader reader = new SystemReader();
    Logic logic = new Logic();
    IntStream.range(0, reader.readlineToInteger())
        .forEach((i) -> System.out.println(logic.getPossible(reader.readlineToInteger())));
  }
}
