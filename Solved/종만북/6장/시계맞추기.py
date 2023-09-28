import math


class Clock:

    def __init__(self):
        self.arr = list(map(int, input().split()))
        self.mv = []
        self.init_mv()
        self.answer = math.inf
        self.visit = [0] * 10

    def init_mv(self):
        self.mv.append([0, 1, 2])
        self.mv.append([3, 7, 9, 11])
        self.mv.append([4, 10, 14, 15])
        self.mv.append([0, 4, 5, 6, 7])
        self.mv.append([6, 7, 8, 10, 12])
        self.mv.append([0, 2, 14, 15])
        self.mv.append([3, 14, 15])
        self.mv.append([4, 5, 7, 14, 15])
        self.mv.append([1, 2, 3, 4, 5])
        self.mv.append([3, 4, 5, 9, 13])

    def get_answer(self):
        self.visit = [0] * 10
        self.dfs(0, 0)
        if self.answer != math.inf:
            return self.answer
        else:
            return -1

    def dfs(self, start, depth):
        if depth >= self.answer:
            return
        flag = True
        for i in self.arr:
            if i != 12:
                flag = False
        if flag:
            self.answer = min(self.answer, depth)
            return

        for i in range(start, 10):
            if self.visit[i] == 3:
                continue
            self.visit[i] += 1
            temp = self.mv[i]
            for t in temp:
                self.arr[t] += 3
                if self.arr[t] > 12:
                    self.arr[t] -= 12
            self.dfs(i, depth + 1)
            for t in temp:
                self.arr[t] -= 3
                if self.arr[t] <= 0:
                    self.arr[t] += 12
            self.visit[i] -= 1


if __name__ == "__main__":
    for _ in range(int(input())):
        clock = Clock()
        print(clock.get_answer())

# Test Case
# 2
# 12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12 -> 2
# 12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6 - > 9