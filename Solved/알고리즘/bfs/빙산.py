import sys
from collections import deque

sys.setrecursionlimit(10 ** 5)


class Ice:
    def __init__(self):
        self.N, self.M = map(int, sys.stdin.readline().split())
        self.arr = []
        self.visit = [[False] * self.M for _ in range(self.N)]
        for _ in range(self.N):
            self.arr.append(list(map(int, sys.stdin.readline().split())))
        self.mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        self.melt_queue = deque([])
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == 0:
                    self.melt_queue.append([i, j])

    def get_answer(self):
        answer = 0
        while True:
            self.visit = [[False] * self.M for _ in range(self.N)]
            temp = 0
            for i in range(self.N):
                for j in range(self.M):
                    if not self.visit[i][j] and self.arr[i][j] != 0:
                        temp += 1
                        self.dfs(i, j)
            if temp > 1:
                return answer
            if temp == 0:
                return 0
            self.melt()
            answer += 1

    def dfs(self, x, y):
        self.visit[x][y] = True
        for mx, my in self.mv:
            tx, ty = mx + x, my + y
            if 0 <= tx < self.N and 0 <= ty < self.M and (not self.visit[tx][ty]) and self.arr[tx][ty] != 0:
                self.dfs(tx, ty)

    def melt(self):
        t_len = len(self.melt_queue)
        for _ in range(t_len):
            x, y = self.melt_queue.popleft()
            flag = False
            for mx, my in self.mv:
                tx, ty = mx + x, my + y
                if 0 <= tx < self.N and 0 <= ty < self.M and self.arr[tx][ty] > 0:
                    self.arr[tx][ty] -= 1
                    if self.arr[tx][ty] == 0:
                        self.melt_queue.append([tx, ty])
                        continue
                    flag = True
            if flag:
                self.melt_queue.append([x, y])


if __name__ == "__main__":
    ice = Ice()
    print(ice.get_answer())
