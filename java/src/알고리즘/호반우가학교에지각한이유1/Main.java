package 알고리즘.호반우가학교에지각한이유1;

import java.util.*;
import java.util.stream.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> list = Stream.generate(scanner::nextInt)
        .limit(4)
        .collect(Collectors.toCollection(ArrayList::new));
    Integer N = scanner.nextInt();
    System.out.println(Math.max(0, 4 * N - list.stream().mapToInt(Integer::intValue).sum()));
  }
}
