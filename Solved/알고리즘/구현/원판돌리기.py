from collections import deque


class Game:
    def __init__(self):
        self.N, self.M, self.K = map(int, input().split())
        self.arr = [deque(list(map(int, input().split()))) for _ in range(self.N)]
        self.mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(self.K):
            self.rotate()
            self.validate()

    def rotate(self):
        x, d, k = map(int, input().split())
        for i in range(1, self.N // x + 1):
            for j in range(k):
                if d == 0:
                    temp = self.arr[i * x - 1].pop()
                    self.arr[i * x - 1].appendleft(temp)
                else:
                    temp = self.arr[i * x - 1].popleft()
                    self.arr[i * x - 1].append(temp)

    def validate(self):
        s = set()
        for x in range(self.N):
            for y in range(self.M):
                if self.arr[x][y] == 0:
                    continue
                for mx, my in self.mv:
                    tx, ty = x + mx, (y + my + self.M) % self.M
                    if tx < 0 or tx >= self.N:
                        continue
                    if self.arr[x][y] == self.arr[tx][ty]:
                        s.add((x, y))
                        continue
        if not s:
            self.plusOrMinus()
        else:
            self.deleteValue(s)

    def plusOrMinus(self):
        amount = 0
        count = 0
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] != 0:
                    count += 1
                    amount += self.arr[i][j]
        if count != 0:
            amount /= count
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == 0:
                    continue
                if self.arr[i][j] > amount:
                    self.arr[i][j] -= 1
                elif self.arr[i][j] < amount:
                    self.arr[i][j] += 1

    def deleteValue(self, s):
        for x, y in s:
            self.arr[x][y] = 0

    def getAnswer(self):
        answer = 0
        for i in range(self.N):
            answer += sum(self.arr[i])
        return answer


if __name__ == "__main__":
    game = Game()
    print(game.getAnswer())
