package 유형.dfs.키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int n;

	static Vector<Integer>[] parentVec;
	static Vector<Integer>[] childVec;

	static boolean[] v;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			childVec = new Vector[n + 1];
			parentVec = new Vector[n + 1];
			for (int i = 0; i <= n; i++) {
				childVec[i] = new Vector<>();
				parentVec[i] = new Vector<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				childVec[a].add(b);
				parentVec[b].add(a);
			}

			v = new boolean[n + 1];
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				Arrays.fill(v, false);
				dfs(i);
				boolean flag = true;
				for (int j = 1; j <= n; j++) {
					if (!v[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}

			System.out.println(cnt);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	static void dfs(int x) {
		v[x] = true;
		child(x);
		parent(x);
	}

	static void child(int x) {
		v[x] = true;
		for (int y : childVec[x]) {
			if (!v[y]) {
				child(y);
			}
		}
	}

	static void parent(int x) {
		v[x] = true;
		for (int y : parentVec[x]) {
			if (!v[y]) {
				parent(y);
			}
		}
	}
}



// public class Main {
// 	static int n;
// 	static Set<Integer>[] parent;
// 	static Set<Integer>[] child;
//
// 	static Vector<Integer>[] parentVec;
// 	static Vector<Integer>[] childVec;
//
// 	public static void main(String[] args) {
// 		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
//
// 			n = Integer.parseInt(st.nextToken());
// 			int m = Integer.parseInt(st.nextToken());
//
// 			parentVec = new Vector[n + 1];
// 			childVec = new Vector[n + 1];
//
// 			for (int i = 0; i < n + 1; i++) {
// 				parentVec[i] = new Vector<>();
// 				childVec[i] = new Vector<>();
// 			}
//
// 			parent = new Set[n + 1];
// 			child = new Set[n + 1];
//
// 			for (int i = 0; i < m; i++) {
// 				st = new StringTokenizer(br.readLine());
// 				int a = Integer.parseInt(st.nextToken());
// 				int b = Integer.parseInt(st.nextToken());
// 				parentVec[a].add(b);
// 				childVec[b].add(a);
// 			}
//
// 			int cnt = 0;
// 			for (int i = 1; i <= n; i++) {
// 				if (possible(i)) {
// 					cnt++;
// 				}
// 			}
//
// 			System.out.println(cnt);
// 		} catch (IOException e) {
// 			throw new RuntimeException();
// 		}
// 	}
//
// 	private static boolean possible(int x) {
// 		Set<Integer> node = new HashSet<>();
// 		node.add(x);
//
// 		Set<Integer> set;
// 		for (int i : parentVec[x]) {
// 			set = parent(i);
// 			for (int y : set) {
// 				node.add(y);
// 			}
// 		}
//
// 		for (int i : childVec[x]) {
// 			set = child(i);
// 			for (int y : set) {
// 				node.add(y);
// 			}
// 		}
//
// 		if (node.size() == n) {
// 			return true;
// 		}
// 		return false;
// 	}
//
// 	private static Set<Integer> parent(int x) {
// 		if (parent[x] == null) {
// 			parent[x] = new HashSet<>();
// 			for (int y : parentVec[x]) {
// 				Set<Integer> set = parent(y);
// 				for (int k : set) {
// 					parent[x].add(k);
// 				}
// 			}
// 			parent[x].add(x);
// 		}
// 		return parent[x];
// 	}
//
//
// 	private static Set<Integer> child(int x) {
// 		if (child[x] == null) {
// 			child[x] = new HashSet<>();
// 			for (int y : childVec[x]) {
// 				Set<Integer> set = child(y);
// 				for (int k : set) {
// 					child[x].add(k);
// 				}
// 			}
// 			child[x].add(x);
// 		}
// 		return child[x];
// 	}
// }
