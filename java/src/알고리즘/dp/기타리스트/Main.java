package 알고리즘.dp.기타리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2023/12/19
 */
class Reader {

  private BufferedReader br;

  public Reader() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public ArrayList<Integer> nextLineToIntegerArray() {
    try {
      return Arrays.stream(br.readLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toCollection(ArrayList::new));
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }
}

class GuitarPerformance {

  private Reader reader;
  private int N;
  private int S;
  private int M;
  private int answer;
  ArrayList<Integer> volumes;


  public GuitarPerformance(Reader reader) {
    this.reader = reader;
    ArrayList<Integer> values = reader.nextLineToIntegerArray();
    N = values.get(0);
    S = values.get(1);
    M = values.get(2);
    answer = -1;
    volumes = reader.nextLineToIntegerArray();
  }

  public void dfs(Set<Integer> set, int depth) {
    if (depth == N) {
      answer = set.size() > 0 ? Collections.max(set) : answer;
      return;
    }
    Set<Integer> nextSet = set.stream()
        .flatMap((i) -> Stream.of(
            i - volumes.get(depth) >= 0 ? i - volumes.get(depth) : null,
            i + volumes.get(depth) <= M ? i + volumes.get(depth) : null
        ))
        .filter(Objects::nonNull)
        .collect(Collectors.toCollection(HashSet::new));
    dfs(nextSet, depth + 1);
  }

  public int getAnswer() {
    Set<Integer> set = new HashSet<>();
    set.add(S);
    dfs(set, 0);
    return answer;
  }
}

public class Main {

  public static void main(String[] args) throws Exception {
    Reader reader = new Reader();
    GuitarPerformance guitarPerformance = new GuitarPerformance(reader);
    System.out.println(guitarPerformance.getAnswer());
  }
}
