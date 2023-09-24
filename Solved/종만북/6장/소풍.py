class Picnic:
    def __init__(self):
        self.N, self.M = map(int, input().split())
        self.vec = [[] for _ in range(self.N)]
        arr = list(map(int, input().split()))
        self.match = [False] * self.N
        self.answer = 0
        for _ in range(self.M):
            a = arr.pop()
            b = arr.pop()
            self.vec[a].append(b)
            self.vec[b].append(a)

    def find_answer(self):
        self.dfs(0)
        print(self.answer)

    def dfs(self, start):
        if sum(self.match) == self.N:
            self.answer += 1
            return
        for i in range(start, self.N):
            if not self.match[i]:
                for j in self.vec[i]:
                    if j < i and (not self.match[j]):
                        self.match[i] = True
                        self.match[j] = True
                        self.dfs(i + 1)
                        self.match[i] = False
                        self.match[j] = False


if __name__ == "__main__":
    for _ in range(int(input())):
        picnic = Picnic()
        picnic.find_answer()

