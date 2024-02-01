package 알고리즘.구현.낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SystemReader {

  private BufferedReader reader;

  public SystemReader() {
    reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public ArrayList<Integer> readToIntegerArr() {
    try {
      return Stream.of(reader.readLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toCollection(ArrayList<Integer>::new));
    } catch (IOException e) {
      throw new RuntimeException("Read Fail!");
    }
  }
}

class FishingService {

  private SystemReader reader;
  private final Integer R;
  private final Integer C;
  private final Integer M;
  private Integer fisher = -1;
  private Integer collect = 0;
  private HashSet<SharkVo> sharks = new HashSet<>();

  public FishingService(SystemReader reader) {
    this.reader = reader;
    ArrayList<Integer> infos = reader.readToIntegerArr();
    R = infos.get(0);
    C = infos.get(1);
    M = infos.get(2);
    IntStream.range(0, M).forEach((i) -> sharks.add(new SharkVo(reader.readToIntegerArr())));
  }

  public void fishing() {
    fisher++;
    SharkVo result = sharks.stream()
        .filter((shark) -> shark.getC() == fisher)
        .reduce((shark1, shark2) -> shark1.getR() < shark2.getR() ? shark1 : shark2)
        .orElse(null);
    if (result != null) {
      collect += result.getZ();
      sharks.remove(result);
    }
  }

  public void moving() {
    HashMap<Integer, SharkVo> hashMap = new HashMap<>();

    sharks.stream().forEach(sharkVo -> sharkVo.move(R, C));
    sharks.stream().forEach((shark) -> {
      Integer hash = shark.getHash();
      if (hashMap.getOrDefault(hash, null) == null) {
        hashMap.put(hash, shark);
      } else {
        SharkVo compare = hashMap.get(hash);
        if (compare.getZ() < shark.getZ()) {
          hashMap.put(hash, shark);
        }
      }
    });
    sharks.clear();
    sharks = hashMap.values().stream().collect(Collectors.toCollection(HashSet<SharkVo>::new));
  }

  public void logic() {
    for (int i = 0; i < C; i++) {
      fishing();
      moving();
    }
    fisher = -1;
  }

  public Integer getCollect() {
    return collect;
  }

}

class SharkVo {

  private Integer r;
  private Integer c;
  private final Integer S;
  private Direction d;
  private final Integer Z;

  public SharkVo(ArrayList<Integer> infos) {
    if (infos.size() != 5) {
      throw new RuntimeException("info 길이가 잘못되었습니다!");
    }
    r = infos.get(0) - 1;
    c = infos.get(1) - 1;
    S = infos.get(2);
    Z = infos.get(4);
    d = Direction.fromValue(infos.get(3));
  }

  private ArrayList<Integer> mv() {
    ArrayList<Integer> result = new ArrayList<>();
    if (d == Direction.UP) {
      result.add(-1);
      result.add(0);
    } else if (d == Direction.DOWN) {
      result.add(1);
      result.add(0);
    } else if (d == Direction.RIGHT) {
      result.add(0);
      result.add(1);
    } else {
      result.add(0);
      result.add(-1);
    }
    return result;
  }

  public Integer getR() {
    return r;
  }

  public Integer getC() {
    return c;
  }

  public Integer getZ() {
    return Z;
  }

  public Integer getHash() {
    return 100 * r + c;
  }

  public void move(Integer x, Integer y) {
    int mvSize = this.S;
    if (d == Direction.DOWN || d == Direction.UP)
      mvSize %= (2 * (x - 1));
    else
      mvSize %= (2 * (y - 1));
    while (mvSize > 0) {
      ArrayList<Integer> mvArr = mv();
      Integer tx = mvArr.get(0) + r;
      Integer ty = mvArr.get(1) + c;
      if (tx < 0 || tx >= x || ty < 0 || ty >= y) {
        d = Direction.reverse(d);
        continue;
      }
      r = tx;
      c = ty;
      mvSize--;
    }
  }
}

enum Direction {
  UP(1),
  DOWN(2),
  RIGHT(3),
  LEFT(4);

  private final Integer num;

  Direction(int num) {
    this.num = num;
  }

  public static Direction fromValue(int num) {
    Optional<Direction> result = Stream.of(Direction.values()).filter((value) -> value.num == num)
        .findFirst();
    if (result.isPresent()) {
      return result.get();
    }
    throw new RuntimeException("해당하는 Direction 이 없습니다!");
  }

  public static Direction reverse(Direction value) {
    switch (value) {
      case UP:
        return DOWN;
      case DOWN:
        return UP;
      case LEFT:
        return RIGHT;
      case RIGHT:
        return LEFT;
      default:
        throw new RuntimeException("잘못된 Direction!");
    }
  }
}

public class Main {

  public static void main(String args[]) {
    SystemReader reader = new SystemReader();
    FishingService fishingService = new FishingService(reader);
    fishingService.logic();
    System.out.println(fishingService.getCollect());
  }
}
