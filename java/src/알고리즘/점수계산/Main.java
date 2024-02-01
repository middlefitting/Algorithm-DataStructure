package 알고리즘.점수계산;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LineReader {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private LineReader() {
    throw new RuntimeException();
  }

  public static ArrayList<Integer> readIntegerLine() {
    try {
      return Stream.of(br.readLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toCollection(ArrayList::new));
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}

public class Main {

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    IntStream.range(0, 8).forEach((i) -> {
      Integer num = LineReader.readIntegerLine().get(0);
      nums.add(num);
      map.put(num, i + 1);
    });
    Collections.sort(nums, Collections.reverseOrder());
    Integer result = 0;
    ArrayList<Integer> idx = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      result += nums.get(i);
      idx.add(map.get(nums.get(i)));
    }
    System.out.println(result);
    Collections.sort(idx);
    idx.stream().forEach((i) -> {
      System.out.print(i);
      System.out.print(" ");
    });
  }

}
