// JIT
public class Hello {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long a = 0;
		// long sum = sum(2, 3);
		// 9억번 실행
		for (long i = 0; i < 900000000L; i++) {
			a += sum(2, 3);
		}
		System.out.println(a);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static long sum(long a, long b) {
		return a + b;
	}
}
