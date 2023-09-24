class Board:
    def __init__(self):
        self.__N, self.__M = map(int, input().split())
        self.__arr = []
        for _ in range(self.__N):
            self.__arr.append(str(input()))
        self.__visit = [[False] * self.__M for _ in range(self.__N)]
        for i in range(self.__N):
            for j in range(self.__M):
                if self.__arr[i][j] == '#':
                    self.__visit[i][j] = True
        self.__answer = 0
        self.__mv = [[1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 1], [1, 0, 1, -1]]

    def get_answer(self):
        self.__dfs()
        return self.__answer

    def __dfs(self):
        flag = False
        x, y = 0, 0
        for i in range(self.__N):
            if flag:
                break
            for j in range(self.__M):
                if not self.__visit[i][j]:
                    flag = True
                    x, y = i, j
                    break
        if not flag:
            self.__answer += 1
            return
        for mx1, my1, mx2, my2 in self.__mv:
            x1, y1, x2, y2 = x + mx1, y + my1, x + mx2, y + my2
            if (0 <= x1 < self.__N) \
                    and (0 <= x2 < self.__N) \
                    and (0 <= y1 < self.__M) \
                    and (0 <= y2 < self.__M):
                if (not self.__visit[x][y]) and (not self.__visit[x1][y1]) and (not self.__visit[x2][y2]):
                    self.__visit[x][y] = True
                    self.__visit[x1][y1] = True
                    self.__visit[x2][y2] = True
                    self.__dfs()
                    self.__visit[x][y] = False
                    self.__visit[x1][y1] = False
                    self.__visit[x2][y2] = False


if __name__ == "__main__":
    for _ in range(int(input())):
        board = Board()
        print(board.get_answer())

# 3
# 3 7
# #.....#
# #.....#
# #.....#
# 3 7
# #.....#
# #.....#
# ##..###
# 8 10
# ##########
# #........#
# #........#
# #........#
# #........#
# #........#
# #........#
# ##########