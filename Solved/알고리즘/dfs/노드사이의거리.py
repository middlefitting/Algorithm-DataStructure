import sys


class Tree:
    def __init__(self, size):
        self.size = size
        self.visit = [False] * (size + 1)
        self.lines = [[] for _ in range(size + 1)]
        for _ in range(size - 1):
            a, b, length = map(int, sys.stdin.readline().split())
            self.lines[a].append([b, length])
            self.lines[b].append([a, length])

    def find_length(self, a, b):
        v = [False] * (self.size + 1)
        self.dfs(a, b, 0, v)

    def dfs(self, a, b, sum_length, v):
        v[a] = True
        for y, length in self.lines[a]:
            if y == b:
                print(sum_length + length)
                return
            if not v[y]:
                self.dfs(y, b, sum_length + length, v)


if __name__ == "__main__":
    N, M = map(int, input().split())
    tree = Tree(N)
    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        tree.find_length(a, b)
