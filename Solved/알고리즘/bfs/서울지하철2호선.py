import sys
from collections import deque
sys.setrecursionlimit(10**4)


class Subway:
    def __init__(self):
        self.N = int(input())
        self.vec = [[] for _ in range(self.N + 1)]
        for i in range(self.N):
            a, b = map(int, input().split())
            self.vec[a].append(b)
            self.vec[b].append(a)
        self.is_circle = [False] * (self.N + 1)
        self.find = False
        self.find_circle()

    def find_circle(self):
        d = dict()
        for i in range(1, self.N):
            for y in self.vec[i]:
                d[str(i) + "@" + str(y)] = 0
                d[str(y) + "@" + str(i)] = 0
        for i in range(1, self.N):
            if self.find:
                break
            if self.is_circle[i]:
                continue
            self.dfs(deque([i]), d)

    def dfs(self, visits, d):
        temp = visits.pop()
        visits.append(temp)
        for i in self.vec[temp]:
            if self.is_circle[i]:
                return
            if not d[str(temp) + "@" + str(i)]:
                if i == visits[0]:
                    for v in visits:
                        self.is_circle[v] = True
                    self.find = True
                    return
                d[str(temp) + "@" + str(i)] = 1
                d[str(i) + "@" + str(temp)] = 1
                visits.append(i)
                self.dfs(visits, d)
                visits.pop()
                d[str(visits[-1]) + "@" + str(i)] -= 1
                d[str(i) + "@" + str(temp)] -= 1

    def get_answers(self):
        answers = []
        for i in range(1, self.N + 1):
            answers.append(self.bfs(i))
        return answers


    def bfs(self, n):
        v = [False] * (self.N + 1)
        if self.is_circle[n]:
            return 0
        queue =deque([[n, 0]])
        v[n] = True
        result = 0
        while queue:
            x, temp = queue.popleft()
            if self.is_circle[x]:
                result = temp
                break
            for y in self.vec[x]:
                if v[y]:
                    continue
                else:
                    v[y] = True
                    queue.append([y, temp + 1])
        return result


if __name__ == "__main__":
    subway = Subway()
    print(" ".join(map(str, subway.get_answers())))




