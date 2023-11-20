class DragonCurve:
    def __init__(self):
        self.arr = [[False] * 101 for _ in range(101)]
        self.dir = [[1, 0], [0, -1], [-1, 0], [0, 1]]

    def dragon_curve(self, x, y, d, g):
        td = self.dir[d]
        dragon = [[x, y], [x + td[0], y + td[1]]]
        for _ in range(g):
            tl = len(dragon)
            for i in range(tl - 1):
                tx, ty = dragon[tl - i - 1][0] - dragon[tl - i - 2][0], dragon[tl - i - 1][1] - dragon[tl - i - 2][1]
                mx, my = ty, tx * -1
                nx, ny = dragon[-1][0] + mx, dragon[-1][1] + my
                dragon.append([nx, ny])
        for i, j in dragon:
            self.arr[i][j] = True

    def get_answer(self):
        answer = 0
        for i in range(100):
            for j in range(100):
                if self.arr[i][j] and self.arr[i + 1][j] and self.arr[i][j + 1] and self.arr[i + 1][j + 1]:
                    answer += 1
        return answer


if __name__ == "__main__":
    N = int(input())
    dragon_curve = DragonCurve()
    for _ in range(N):
        x, y, d, g = map(int, input().split())
        dragon_curve.dragon_curve(x, y, d, g)
    print(dragon_curve.get_answer())

