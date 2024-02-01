package 알고리즘.구현.새로운게임2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LineReader {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private LineReader() {
    throw new RuntimeException();
  }

  static ArrayList<Integer> readIntLine() {
    try {
      return Stream.of(br.readLine().split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toCollection(ArrayList::new));
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}

class Horse {

  private int x;
  private int y;
  private Direction direction;

  public Horse(int x, int y, int direction) {
    this.x = x - 1;
    this.y = y - 1;
    this.direction = Direction.fromValue(direction);
  }

  // 1→, 2←, 3↑ ,4↓
  enum Direction {
    RIGHT(1, 0, 1),
    LEFT(2, 0, -1),
    UP(3, -1, 0),
    DOWN(4, 1, 0);

    public final int num;
    public final int mx;
    public final int my;

    Direction(int num, int mx, int my) {
      this.num = num;
      this.mx = mx;
      this.my = my;
    }

    public static Direction fromValue(int num) {
      for (Direction d : Direction.values()) {
        if (d.num == num) {
          return d;
        }
      }
      throw new RuntimeException();
    }

    public static Direction changeDir(Direction direction) {
      if (direction == RIGHT) {
        return LEFT;
      } else if (direction == LEFT) {
        return RIGHT;
      } else if (direction == UP) {
        return DOWN;
      } else {
        return UP;
      }
    }
  }

  public Horse(ArrayList<Integer> infos) {
    if (infos.size() != 3) {
      throw new RuntimeException();
    }
    this.x = infos.get(0) - 1;
    this.y = infos.get(1) - 1;
    this.direction = Direction.fromValue(infos.get(2));
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Direction getDirection() {
    return direction;
  }

  public void changeDirection() {
    direction = Direction.changeDir(direction);
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}

class Game {

  private final int N;
  private final int K;
  private final ArrayList<ArrayList<Integer>> colors = new ArrayList<>();
  private final HashMap<Integer, Horse> horses = new HashMap<>();
  private final ArrayList<ArrayList<LinkedList<Horse>>> worldMap = new ArrayList<>();

  public Game() {
    ArrayList<Integer> map_info = LineReader.readIntLine();
    N = map_info.get(0);
    K = map_info.get(1);
    IntStream.range(0, N).forEach((i) -> colors.add(LineReader.readIntLine()));
    IntStream.range(1, K + 1).forEach((i) -> horses.put(i, new Horse(LineReader.readIntLine())));
    IntStream.range(0, N).forEach((i) -> worldMap.add(new ArrayList<>()));
    worldMap.stream().forEach((arr) -> IntStream.range(0, N).forEach((j) -> arr.add(new LinkedList<>())));
    horses.values().stream().forEach((horse) -> worldMap.get(horse.getX()).get(horse.getY()).addLast(horse));
  }

  public int startGame() {
    for (int i = 1; i < 1001; i++) {
      if (turn()) {
        return i;
      }
    }
    return -1;
  }

  private boolean turn() {
    for (int i = 1; i < K + 1; i++) {
      if (mv_finish(i)) {
        return true;
      }
    }
    return false;
  }

  private boolean mv_finish(int idx) {
    Horse horse = horses.get(idx);
    if (!worldMap.get(horse.getX()).get(horse.getY()).contains(horse)) {
      return false;
    }
    mv(horse);
    if (worldMap.get(horse.getX()).get(horse.getY()).size() >= 4) {
      return true;
    }
    return false;
  }

  private void mv(Horse horse) {
    int x = horse.getX();
    int y = horse.getY();

    int tx = x + horse.getDirection().mx;
    int ty = y + horse.getDirection().my;
    // blue event
    if (tx < 0 || ty < 0 || tx >= N || ty >= N || colors.get(tx).get(ty) == 2) {
      tx -= (horse.getDirection().mx * 2);
      ty -= (horse.getDirection().my * 2);
      horse.changeDirection();

    }
    if (tx < 0 || ty < 0 || tx >= N || ty >= N || colors.get(tx).get(ty) == 2) {
      tx = x;
      ty = y;
    }
    if (tx == horse.getX() && ty == horse.getY()) {
      return;
    }

    // mv event
    LinkedList<Horse> temp = new LinkedList<>();
    while (!worldMap.get(x).get(y).getLast().equals(horse)) {
      Horse t_horse = worldMap.get(x).get(y).removeLast();
      temp.addLast(t_horse);
      t_horse.setX(tx);
      t_horse.setY(ty);
    }
    Horse t_horse = worldMap.get(x).get(y).removeLast();
    temp.addLast(t_horse);
    t_horse.setX(tx);
    t_horse.setY(ty);

    while (!temp.isEmpty()) {
      // red || white event
      if (colors.get(tx).get(ty) == 1) {
        worldMap.get(tx).get(ty).addLast(temp.removeFirst());
      } else {
        worldMap.get(tx).get(ty).addLast(temp.removeLast());
      }
    }
  }
}

public class Main {

  public static void main(String[] args) {
    Game game = new Game();
    System.out.println(game.startGame());
  }
}
