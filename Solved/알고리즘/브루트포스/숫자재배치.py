# 1234 3456

import sys

sin = sys.stdin.readline


class BigNumber:
    def __init__(self, x, y):
        self.N = len(str(x))
        self.x = x
        self.y = y
        self.d = dict()
        for i in str(x):
            if i in self.d:
                self.d[i] += 1
            else:
                self.d[i] = 1
        self.answer = -1
        self.dfs(0, "")

    def dfs(self, depth, temp):
        if depth == self.N and int(temp) < self.y:
            self.answer = max(self.answer, int(temp))
        for key, value in self.d.items():
            if len(temp) == 0 and key == "0":
                continue
            if self.d[key] > 0:
                self.d[key] -= 1
                self.dfs(depth + 1, temp + key)
                self.d[key] += 1

    def get_answer(self):
        return self.answer


if __name__ == "__main__":
    A, B = map(int, sin().split())
    bigNumber = BigNumber(A, B)
    print(bigNumber.get_answer())
