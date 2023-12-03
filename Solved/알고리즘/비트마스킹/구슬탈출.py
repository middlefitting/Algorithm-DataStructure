import math


class ExitGame:
    def __init__(self):
        self.N, self.M = map(int, input().split())
        self.arr = [list(str(input())) for _ in range(self.N)]
        self.answer = math.inf
        self.visit = dict()
        self.mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == "O":
                    self.ox = i
                    self.oy = j

    def start_game(self):
        rx, ry, bx, by = 0, 0, 0, 0
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == "R":
                    rx, ry = i, j
                if self.arr[i][j] == "B":
                    bx, by = i, j
        self.dfs(rx, ry, bx, by, 1)

    def dfs(self, rx, ry, bx, by, depth):
        hash_code = self.get_hash(rx, ry, bx, by)
        try:
            if self.visit[hash_code] <= depth:
                return
        except KeyError:
            self.visit[hash_code] = depth
        if depth >= self.answer:
            return
        if depth > 10:
            return
        for mx, my in self.mv:
            self.move(rx, ry, bx, by, mx, my, depth)
            self.arr[rx][ry] = "R"
            self.arr[bx][by] = "B"

    def get_hash(self, rx, ry, bx, by):
        return str(rx) + "@" + str(ry) + "@" + str(bx) + "@" + str(by)

    def move(self, rx, ry, bx, by, mx, my, depth):
        if (mx == 1 and rx >= bx) or (mx == -1 and rx <= bx) or (my == 1 and ry >= by) or (my == -1 and ry <= by):
            nrx, nry, rflag = self.do_mv(rx, ry, mx, my)
            self.arr[rx][ry] = "."
            self.arr[nrx][nry] = "R"
            self.arr[self.ox][self.oy] = "O"
            nbx, nby, flag = self.do_mv(bx, by, mx, my)
            if flag:
                self.arr[nrx][nry] = "."
                return
            if rflag:
                self.answer = min(self.answer, depth)
                self.arr[nrx][nry] = "."
                self.arr[nbx][nby] = "."
                self.arr[self.ox][self.oy] = "O"
                return
            self.arr[bx][by] = "."
            self.arr[nbx][nby] = "B"
            self.dfs(nrx, nry, nbx, nby, depth + 1)
            self.arr[nrx][nry] = "."
            self.arr[nbx][nby] = "."
            return
        else:
            nbx, nby, flag = self.do_mv(bx, by, mx, my)
            if flag:
                return
            self.arr[bx][by] = "."
            self.arr[nbx][nby] = "B"
            nrx, nry, flag = self.do_mv(rx, ry, mx, my)
            if flag:
                self.answer = min(self.answer, depth)
                self.arr[nbx][nby] = "."
                self.arr[self.ox][self.oy] = "O"
                return
            self.arr[rx][ry] = "."
            self.arr[nrx][nry] = "R"
            self.dfs(nrx, nry, nbx, nby, depth + 1)
            self.arr[nrx][nry] = "."
            self.arr[nbx][nby] = "."
            return

    def do_mv(self, x, y, mx, my):
        flag = False
        while True:
            tx, ty = x + mx, y + my
            if tx < 0 or tx >= self.N or ty < 0 or ty >= self.M:
                break
            if self.is_finish(tx, ty):
                x, y, flag = tx, ty, True
                break
            if not self.mv_possible(tx, ty):
                break
            x, y = tx, ty
        return [x, y, flag]

    def is_finish(self, x, y):
        if self.arr[x][y] == "O":
            return True
        return False

    def mv_possible(self, x, y):
        if self.arr[x][y] == ".":
            return True
        return False

    def get_answer(self):
        if self.answer == math.inf:
            return -1
        else:
            return self.answer


if __name__ == "__main__":
    game = ExitGame()
    game.start_game()
    print(game.get_answer())
