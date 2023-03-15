import sys


class TermProject:
    def __init__(self, size, vec):
        self.__v = [0] * size
        self.__f = [0] * size
        self.__vec = vec
        self.__cnt = 0

    def visit(self, x):
        return self.__v[x]

    def find_cycle(self, x):
        self.__v[x] = 1
        target = self.__vec[x]
        if self.__v[target]:
            if not self.__f[target]:
                while target != x:
                    self.__cnt += 1
                    target = self.__vec[target]
                self.__cnt += 1
        else:
            self.find_cycle(target)
        self.__f[x] = 1

    def get_cnt(self):
        return self.__cnt


if __name__ == "__main__":
    sys.setrecursionlimit(10 ** 5)
    for _ in range(int(input())):
        N = int(input())
        vec = list(map(int, input().split()))
        for i in range(N):
            vec[i] -= 1
        termProject = TermProject(N, vec)
        for i in range(N):
            if not termProject.visit(i):
                termProject.find_cycle(i)
        print(N - termProject.get_cnt())
