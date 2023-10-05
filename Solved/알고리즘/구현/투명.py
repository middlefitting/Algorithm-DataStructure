class Mosaik:
    def __init__(self, m):
        self.mosaik = [[m] * 100 for _ in range(100)]

    def hide(self, x1, y1, x2, y2):
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                self.mosaik[i][j] -= 1

    def get_anwser(self):
        answer = 0
        for i in range(100):
            for j in range(100):
                if self.mosaik[i][j] < 0:
                    answer += 1
        return answer


if __name__ == "__main__":
    N, M = map(int, input().split())
    mosaik = Mosaik(M)
    for _ in range(N):
        x1, y1, x2, y2 = map(int, input().split())
        mosaik.hide(x1 - 1, y1 - 1, x2 - 1, y2 - 1)
    print(mosaik.get_anwser())


