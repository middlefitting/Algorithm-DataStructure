import math
from collections import deque


class Bfs:
    def __init__(self):
        self.N, self.M = map(int, input().split())
        self.vec = [[] for _ in range(self.N + 1)]
        for _ in range(self.M):
            a, b = map(int, input().split())
            self.vec[a].append(b)
            self.vec[b].append(a)

    def bfs(self, start):
        v = [False] * (self.N + 1)
        v[start] = True
        result = 0
        queue = deque([[start, 0]])
        while queue:
            x, temp = queue.popleft()
            result += temp
            for y in self.vec[x]:
                if not v[y]:
                    v[y] = True
                    queue.append([y, temp + 1])
        return result

    def kavin_baikon(self):
        answer = math.inf
        result = -1
        for i in range(1, self.N + 1):
            temp = self.bfs(i)
            if temp < answer:
                answer = temp
                result = i
        return result


if __name__ == "__main__":
    bfs = Bfs()
    print(bfs.kavin_baikon())
