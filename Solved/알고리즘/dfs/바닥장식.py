class Floor:
    def __init__(self):
        self.__N, self.__M = map(int, input().split())
        self.__floor = []
        self.__visit = []
        self.__mv = dict()
        self.__mv['-'] = [[0, 1], [0, -1]]
        self.__mv['|'] = [[1, 0], [-1, 0]]
        for _ in range(self.__N):
            self.__floor.append(str(input()))
            self.__visit.append([False] * self.__M)

    def __dfs(self, x, y):
        self.__visit[x][y] = True
        for mx, my in self.__mv[self.__floor[x][y]]:
            tx, ty = x + mx, y + my
            if 0 <= tx < self.__N \
                    and 0 <= ty < self.__M \
                    and (not self.__visit[tx][ty]) \
                    and (self.__floor[x][y] == self.__floor[tx][ty]):
                self.__dfs(tx, ty)

    def count_element(self):
        answer = 0
        for i in range(self.__N):
            for j in range(self.__M):
                if not self.__visit[i][j]:
                    self.__dfs(i, j)
                    answer += 1
        return answer


if __name__ == "__main__":
    floor = Floor()
    print(floor.count_element())
