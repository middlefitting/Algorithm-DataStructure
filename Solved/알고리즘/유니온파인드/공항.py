class Airport:
    def __init__(self, n):
        self._uf = [-1] * (n + 1)

    def _getUfElement(self, ind):
        return self._uf[ind]

    def _setUfElement(self, ind, value):
        self._uf[ind] = value

    def _find(self, a):
        if self._getUfElement(a) < 0:
            return a
        self._setUfElement(a, self._find(self._getUfElement(a)))
        return self._find(self._getUfElement(a))

    def _merge(self, a, b):
        a = self._find(a)
        b = self._find(b)
        if a == b:
            return
        self._setUfElement(b, a)

    def lending(self, a):
        target = self._find(a)
        if target > 0:
            self._merge(target - 1, target)
            return True
        else:
            return False


if __name__ == "__main__":
    airport = Airport(int(input()))
    answer = 0
    for i in range(int(input())):
        if airport.lending(int(input())):
            answer += 1
        else:
            break
    print(answer)
