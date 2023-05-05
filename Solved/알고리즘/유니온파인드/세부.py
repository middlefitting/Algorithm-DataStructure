import heapq
import sys
sys.setrecursionlimit(10 ** 6)


class UnionFinder:
    def __init__(self, ncnt, lcnt):
        self._command = []
        self._uf = [-1] * (ncnt + 1)
        for _ in range(lcnt):
            a, b, l = map(int, sys.stdin.readline().split())
            heapq.heappush(self._command, [-1 * l, a, b])

    def _find(self, a):
        if self._uf[a] < 0:
            return a
        self._uf[a] = self._find(self._uf[a])
        return self._find(self._uf[a])

    def _merge(self, a, b):
        a = self._find(a)
        b = self._find(b)
        if a != b:
            self._uf[b] = a

    def findAnswer(self, s, e):
        while self._command:
            tl, ta, tb = heapq.heappop(self._command)
            self._merge(ta, tb)
            if self._find(s) == self._find(e):
                return tl * -1
        return 0


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    S, E = map(int, sys.stdin.readline().split())
    union_finder = UnionFinder(N, M)
    print(union_finder.findAnswer(S, E))
