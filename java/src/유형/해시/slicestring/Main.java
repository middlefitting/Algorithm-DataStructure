package 유형.해시.slicestring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			br.readLine();

			HashSet<String> set = new HashSet<>(Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList()));

			br.readLine();

			Arrays.stream(br.readLine().split(" ")).forEach(set::add);

			br.readLine();

			Arrays.stream(br.readLine().split(" ")).forEach(set::remove);

			String separate = set.stream().collect(Collectors.joining("|"));

			br.readLine();
			if (separate.isEmpty()) {
				separate = separate + " ";
			} else {
				separate = separate + "| ";
			}
			System.out.print(Arrays.stream(br.readLine().split(separate + "| ")).filter((s) -> !s.isEmpty()).collect(Collectors.joining("\n")));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
