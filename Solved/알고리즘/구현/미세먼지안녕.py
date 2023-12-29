
class AirConditional:
    def __init__(self):
        self.N, self.M, self.T = map(int, input().split())
        self.arr = [list(map(int, input().split())) for _ in range(self.N)]
        self.dust = [[0] * self.M for _ in range(self.N)]
        self.up = 0
        self.down = 0
        self.mv = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        flag = False
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] == -1:
                    if not flag:
                        self.up = i
                        flag = True
                    else:
                        self.down = i

    def dust_moving(self):
        for i in range(self.N):
            for j in range(self.M):
                if self.arr[i][j] < 5:
                    continue
                amount = self.arr[i][j] // 5
                for mx, my in self.mv:
                    tx, ty = i + mx, j + my
                    if tx < 0 or tx >= self.N or ty < 0 or ty >= self.M or self.arr[tx][ty] == -1:
                        continue
                    self.dust[tx][ty] += amount
                    self.arr[i][j] -= amount

    def dust_append(self):
        for i in range(self.N):
            for j in range(self.M):
                if self.dust[i][j]:
                    self.arr[i][j] += self.dust[i][j]
                    self.dust[i][j] = 0

    def air_fresh(self):
        # for i in range(self.N):
        #     print(self.arr[i])
        # print("!!!!!!!!!!!!!!!!!!!!!!!!")

        self.arr[self.down + 1][0] = 0
        self.arr[self.up - 1][0] = 0
        for i in range(self.down + 2, self.N):
            self.arr[i - 1][0] = self.arr[i][0]
            self.arr[i][0] = 0

        i = self.up - 2
        while i >= 0:
            self.arr[i + 1][0] = self.arr[i][0]
            self.arr[i][0] = 0
            i -= 1

        # for i in range(self.up - 2):
        #     self.arr[i + 1][0] = self.arr[i][0]
        #     self.arr[i][0] = 0

        for i in range(1, self.M):
            self.arr[0][i - 1] = self.arr[0][i]
            self.arr[0][i] = 0
            self.arr[self.N - 1][i - 1] = self.arr[self.N - 1][i]
            self.arr[self.N - 1][i] = 0

        i = self.N - 2
        while i >= self.down:
            self.arr[i + 1][self.M - 1] = self.arr[i][self.M - 1]
            self.arr[i][self.M - 1] = 0
            i -= 1
        # for j in range(2, self.M - self.down):
        #     i = self.N - j
        #     self.arr[i + 1][self.M - 1] = self.arr[i][self.M - 1]
        #     self.arr[i][self.M - 1] = 0
        # for i in range(self.N):
        #     print(self.arr[i])
        # print("////////////////////")
        for i in range(1, self.up + 1):
            self.arr[i - 1][self.M - 1] = self.arr[i][self.M - 1]
            self.arr[i][self.M - 1] = 0

        for j in range(2, self.M):
            i = self.M - j
            self.arr[self.up][i + 1] = self.arr[self.up][i]
            self.arr[self.up][i] = 0
            self.arr[self.down][i + 1] = self.arr[self.down][i]
            self.arr[self.down][i] = 0
        # for i in range(self.N):
        #     print(self.arr[i])
        # print("////////////////////")


    def logic(self):
        for i in range(self.T):
            self.dust_moving()
            self.dust_append()
            self.air_fresh()

    def get_answer(self):
        answer = 0
        for i in range(self.N):
            for j in range(self.M):
                answer += max(0, self.arr[i][j])
        return answer


if __name__ == "__main__":
    air_conditional = AirConditional()
    air_conditional.logic()
    print(air_conditional.get_answer())

# 7 8 1000
# 0 0 0 0 0 0 0 9
# 0 0 0 0 3 0 0 8
# 0 0 5 0 0 0 22 0
# -1 8 0 0 0 0 0 0
# -1 0 0 0 0 10 43 0
# 0 0 5 0 15 0 0 0
# 0 0 40 0 0 0 20 0
#
# 8 8 2
# 3 0 0 0 0 0 0 0
# 0 0 0 0 0 0 0 9
# 0 0 0 0 3 0 0 8
# -1 0 5 0 0 0 22 0
# -1 8 0 0 0 0 0 0
# 0 0 0 0 0 10 43 0
# 0 0 5 0 15 0 0 0
# 0 0 40 0 0 0 20 0