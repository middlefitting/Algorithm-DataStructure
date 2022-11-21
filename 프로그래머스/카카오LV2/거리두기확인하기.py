# places 원소의 길이(대기실 가로 길이) = 5
# P는 응시자가 앉아있는 자리를 의미합니다.
# O는 빈 테이블을 의미합니다.
# X는 파티션을 의미합니다.
possible = [True]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]


def dfs(arr, depth, i, j):
    if depth == 2:
        return
    temp = arr.copy()
    temp[i][j] = "X"
    for x, y in mv:
        next_i = i + x
        next_j = j + y
        if 0 <= next_i < 5 and 0 <= next_j < 5:
            if temp[next_i][next_j] == "O":
                dfs(temp, depth + 1, next_i, next_j)
            if temp[next_i][next_j] == "P":
                possible[0] = False
                return


def solution(places):
    result = []

    for arr in places:
        temp = [[] for _ in range(5)]
        for n in range(5):
            for m in range(5):
                temp[n].append(arr[n][m])

        possible[0] = True
        for i in range(5):
            for j in range(5):
                if temp[i][j] == "P":
                    dfs(temp, 0, i, j)
        if possible[0]:
            result.append(1)
        else:
            result.append(0)

    return result


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))
