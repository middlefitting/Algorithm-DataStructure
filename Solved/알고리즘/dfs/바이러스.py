class Network:
    def __init__(self, size):
        self.size = size
        self.visit = [False] * (size + 1)
        self.vector = [[] for _ in range(size + 1)]
        for _ in range(int(input())):
            a, b = map(int, input().split())
            self.vector[a].append(b)
            self.vector[b].append(a)

    def get_virus_count(self):
        self.dfs(1)
        return sum(self.visit) - 1

    def dfs(self, x):
        self.visit[x] = True
        for y in self.vector[x]:
            if not self.visit[y]:
                self.dfs(y)


if __name__ == "__main__":
    N = int(input())
    network = Network(N)
    print(network.get_virus_count())
