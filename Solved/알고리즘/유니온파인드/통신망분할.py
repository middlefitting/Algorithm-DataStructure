import sys


class Network:
    def __init__(self, N, M, Q):
        self._uf = [-1] * (N + 1)
        self._line = [[]]
        self._start = dict()
        self._cost = 0
        self._to_merge = []
        self._initial(M ,Q)
        self._begin()
        self._calculate()

    def _initial(self, M, Q):
        for i in range(1, M + 1):
            self._line.append(list(map(int, sys.stdin.readline().split())))
            self._start[i] = True
        for i in range(Q):
            ln = int(sys.stdin.readline())
            self._start[ln] = False
            self._to_merge.append(ln)

    def _begin(self):
        for key, value in self._start.items():
            if value:
                self._merge(self._line[key][0], self._line[key][1])

    def _calculate(self):
        for ind in self._to_merge:
            self._cost += self._merge(self._line[ind][0], self._line[ind][1])

    def _find(self, a):
        if self._uf[a] < 0:
            return a
        self._uf[a] = self._find(self._uf[a])
        return self._find(self._uf[a])

    def _merge(self, a, b):
        a = self._find(a)
        b = self._find(b)
        if a == b:
            return 0
        temp_cost = self._uf[a] * self._uf[b]
        self._uf[a] += self._uf[b]
        self._uf[b] = a
        return temp_cost

    def get_cost(self):
        return self._cost


if __name__ == "__main__":
    N, M, Q = map(int, sys.stdin.readline().split())
    network = Network(N, M, Q)
    print(network.get_cost())
