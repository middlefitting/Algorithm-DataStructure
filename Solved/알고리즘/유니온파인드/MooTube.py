import sys
import heapq


class UnionFinder:
    def __init__(self, n, q):
        self._lines = []
        self._command = []
        self._answer = [0] * q
        self._uf = [-1] * (n + 1)
        for _ in range(n - 1):
            a, b, r = map(int, sys.stdin.readline().split())
            heapq.heappush(self._lines, [-1 * r, a, b])
        for i in range(q):
            k, v = map(int, sys.stdin.readline().split())
            heapq.heappush(self._command, [-1 * k, v, i])

        while self._command:
            k, v, ind = heapq.heappop(self._command)
            while self._lines and self._lines[0][0] <= k:
                r, a, b = heapq.heappop(self._lines)
                self._union(a, b)
            self._answer[ind] = self._uf[self._find(v)] * -1 - 1

    def _find(self,a ):
        if self._uf[a] < 0:
            return a
        self._uf[a] = self._find(self._uf[a])
        return self._find(self._uf[a])

    def _union(self, a, b):
        a = self._find(a)
        b = self._find(b)
        if a == b:
            return
        self._uf[a] += self._uf[b]
        self._uf[b] = a

    def get_anwer(self):
        return self._answer


if __name__ == "__main__":
    N, Q = map(int, sys.stdin.readline().split())
    union_finder = UnionFinder(N, Q)
    for i in (union_finder.get_anwer()):
        print(i)
