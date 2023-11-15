class Bridge:
    def __init__(self, n):
        self.uf = [-1] * n
        self.answer = 0

    def find(self, a):
        if self.uf[a] < 0:
            return a
        self.uf[a] = self.find(self.uf[a])
        return self.find(self.uf[a])

    def union(self, a, b, cost):
        a = self.find(a)
        b = self.find(b)
        if a == b:
            return False
        self.uf[a] = b
        self.answer += cost
        return True

    def get_answer(self):
        return self.answer


def solution(n, costs):
    costs.sort(key=lambda x: x[2])
    bridge = Bridge(n)
    for a, b, c in costs:
        bridge.union(a, b, c)
    return bridge.get_answer()