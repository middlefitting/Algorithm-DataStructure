class Tree:
    def __init__(self):
        self.N, self.M, self.K = map(int, input().split())
        self.A = [list(map(int, input().split())) for _ in range(self.N)]
        self.T = [[[] for _ in range(self.N)] for __ in range(self.N)]
        self.D = [[0] * self.N for _ in range(self.N)]
        self.E = [[5] * self.N for _ in range(self.N)]
        self.MV = [[0, 1], [1, 0], [-1, 0], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]
        for i in range(self.M):
            x, y, a = map(int, input().split())
            self.T[x - 1][y - 1].append(a)

    def spring(self):
        for i in range(self.N):
            for j in range(self.N):
                if not self.T[i][j]:
                    continue
                temp = []
                self.T[i][j].sort(reverse=True)
                while self.T[i][j]:
                    tree = self.T[i][j].pop()
                    if self.E[i][j] >= tree:
                        self.E[i][j] -= tree
                        temp.append(tree + 1)
                    else:
                        self.D[i][j] += tree // 2
                self.T[i][j] = temp

    def summer(self):
        for i in range(self.N):
            for j in range(self.N):
                self.E[i][j] += self.D[i][j]
                self.D[i][j] = 0

    def autumn(self):
        for i in range(self.N):
            for j in range(self.N):
                for tree in self.T[i][j]:
                    if tree % 5 == 0:
                        for mx, my in self.MV:
                            tx, ty = i + mx, j + my
                            if tx < 0 or tx >= self.N or ty < 0 or ty >= self.N:
                                continue
                            self.T[tx][ty].append(1)

    def winter(self):
        for i in range(self.N):
            for j in range(self.N):
                self.E[i][j] += self.A[i][j]

    def logic(self):
        for i in range(self.K):
            self.spring()
            self.summer()
            self.autumn()
            self.winter()

    def getAnswer(self):
        answer = 0
        for i in range(self.N):
            for j in range(self.N):
                answer += len(self.T[i][j])
        return answer


if __name__ == "__main__":
    tree = Tree()
    tree.logic()
    print(tree.getAnswer())
