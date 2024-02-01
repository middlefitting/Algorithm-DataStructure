package 알고리즘.dp.크리보드;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

/**
 * Main.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/11
 */


public class Main {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer n;

    try {
      n = Integer.parseInt(br.readLine());
    } catch (Exception ex) {
      throw new RuntimeException();
    }

    ArrayList<Long> dp = new ArrayList<>();
    IntStream.range(0, 101).forEach((i) -> dp.add((long) i));
    for (int i = 4; i < 101; i++) {
      Long temp = dp.get(i - 3);
      for (int j = i; j < 101; j++) {
        dp.set(j, Long.max(dp.get(j), dp.get(i - 3) + (temp * (j - i + 1))));
      }
    }
    System.out.println(dp.get(n));
  }
}
