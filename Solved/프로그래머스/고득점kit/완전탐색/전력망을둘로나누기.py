from collections import deque
import math


class Network:
    def __init__(self, wires, n):
        self.wires = wires
        self.N = n
        self.v = []
        self.vec = []

    def bfs(self):
        cnt = 0
        for i in range(self.N):
            if not self.v[i]:
                queue = deque([i])
                self.v[i] = True
                while queue:
                    x = queue.popleft()
                    cnt += 1
                    for y in self.vec[x]:
                        if not self.v[y]:
                            self.v[y] = True
                            queue.append(y)
                break
        return cnt

    def get_answer(self):
        result = math.inf
        for i in range(self.N - 1):
            self.vec = [[] for _ in range(self.N)]
            self.v = [False] * self.N
            for j in range(self.N - 1):
                if i == j:
                    continue
                a, b = self.wires[j]
                self.vec[a - 1].append(b - 1)
                self.vec[b - 1].append(a - 1)
            group1 = self.bfs()
            group2 = self.bfs()
            result = min(result, abs(group1 - group2))
        return result


def solution(n, wires):
    answer = -1
    network = Network(wires, n)
    return network.get_answer()