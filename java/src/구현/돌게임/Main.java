package 구현.돌게임;

import java.io.*;

public class Main {
  public static void main(String args[]) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer N;
    try {
       N = Integer.parseInt(br.readLine());
    } catch (Exception e) {
      throw new RuntimeException();
    }
    if (N % 2 != 0) {
      System.out.println("SK");
    } else {
      System.out.println("CY");
    }
  }

}
