class Fight:
    def __init__(self):
        self.M, self.N = map(int, input().split())
        self.arr = []
        for _ in range(self.N):
            self.arr.append(str(input()))
        self.mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        self.visit = [[False] * self.M for _ in range(self.N)]

    def dfs(self, x, y):
        self.visit[x][y] = True
        result = 1
        for mx, my in self.mv:
            tx, ty = x + mx, y + my
            if 0 <= tx < self.N and 0 <= ty < self.M and not self.visit[tx][ty] and self.arr[x][y] == self.arr[tx][ty]:
                result += self.dfs(tx, ty)
        return result

    def print_result(self):
        team = 0
        enemy = 0
        for i in range(self.N):
            for j in range(self.M):
                if not self.visit[i][j]:
                    temp = self.dfs(i, j)
                    if self.arr[i][j] == 'B':
                        enemy += temp ** 2
                    else:
                        team += temp ** 2
        print(team, enemy)


if __name__ == "__main__":
    fight = Fight()
    fight.print_result()

