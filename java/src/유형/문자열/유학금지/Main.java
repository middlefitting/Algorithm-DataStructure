import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			char[] arr = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};
			String result = "";
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				boolean flag = true;
				char temp = s.charAt(i);
				for (char c : arr) {
					if (temp == c) {
						flag = false;
					}
				}
				if (flag) {
					result += temp;
				}
			}
			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
