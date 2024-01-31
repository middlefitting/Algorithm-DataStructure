// package 브루트포스.배열돌리기;
//
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// class Reader {
// 	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
// 	private Reader() {
// 		throw new RuntimeException();
// 	}
//
// 	public static ArrayList<Integer> readIntegerLine() {
// 		try {
// 			Stream.of(br.readLine().split(" "))
// 				.map(Integer::parseInt)
// 				.collect(Collectors.toCollection(ArrayList::new));
// 		} catch (Exception e) {
// 			throw new RuntimeException();
// 		}
// 	}
// }
//
// public class Main {
// 	public static void main(String args[]) {
// 		ArrayList<Integer> conditions = Reader.readIntegerLine();
// 	}
// }
