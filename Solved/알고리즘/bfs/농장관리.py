import sys


class Tree:
    def __init__(self, height, width):
        self.height = height
        self.width = width
        self.arr = []
        self.answer = 0
        self.visit = [[False] * (1 * self.width) for _ in range(1 + self.height)]
        self.mv = [[1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [1, -1], [-1, -1], [-1, 1]]
        for _ in range(height):
            self.arr.append(list(map(int, sys.stdin.readline().split())))

    def calc_top(self):
        # self.answer = 0
        # self.visit = [[False] * (1 * self.width) for _ in range(1 + self.height)]
        for i in range(self.height):
            for j in range(self.width):
                temp = self.bfs(i, j)
                if temp:
                    self.answer += 1
        return self.answer

    def bfs(self, i, j):
        flag = True
        temp = self.arr[i][j]
        if self.visit[i][j]:
            return False
        self.visit[i][j] = True
        for mx, my in self.mv:
            if i + mx < 0 or j + my < 0 or i + mx >= self.height or j + my >= self.width:
                continue
            if self.arr[i + mx][j + my] > temp:
                flag = False
            if self.arr[i + mx][j + my] == temp and (not self.visit[i + mx][j + my]):
                result = self.bfs(i + mx, j + my)
                if not result:
                    flag = False
        return flag


if __name__ == "__main__":
    N, M = map(int, input().split())
    tree = Tree(N, M)
    print(tree.calc_top())
