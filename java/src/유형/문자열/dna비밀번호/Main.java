package 유형.문자열.dna비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	private static char[] chars;
	private static DNA dna;
	private static int n;

	public static void main(String[] args) {
		parse();
		System.out.println(dna.calcPossible(chars, n));
	}

	private static void parse() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			chars = br.readLine().toCharArray();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			dna = new DNA(m, a, c, g, t);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private static class DNA {
		private int m;
		private HashMap<Character, Integer> needSize = new HashMap<>();

		public DNA(int m, int a, int c, int g, int t) {
			this.m = m;
			needSize.put('A', a);
			needSize.put('C', c);
			needSize.put('G', g);
			needSize.put('T', t);
		}

		public int calcPossible(char[] arr, int n) {
			if (n < m) {
				return 0;
			}

			int result = 0;
			int s = 0;
			HashMap<Character, Integer> calc = new HashMap<>();
			for (int i = 0; i < m; i++) {
				calc.put(arr[i], calc.getOrDefault(arr[i], 0) + 1);
			}
			if (isPossible(calc)) {
				result++;
			}

			for (int i = m; i < n; i++) {
				calc.put(arr[s], calc.getOrDefault(arr[s], 0) - 1);
				s++;
				calc.put(arr[i], calc.getOrDefault(arr[i], 0) + 1);
				if (isPossible(calc)) {
					result++;
				}
			}
			return result;
		}

		private boolean isPossible(HashMap<Character, Integer> compare) {
			boolean a = compare.getOrDefault('A', 0) >= needSize.get('A');
			boolean c = compare.getOrDefault('C', 0) >= needSize.get('C');
			boolean g = compare.getOrDefault('G', 0) >= needSize.get('G');
			boolean t = compare.getOrDefault('T', 0) >= needSize.get('T');
			return a && c && g && t;
		}
	}
}
