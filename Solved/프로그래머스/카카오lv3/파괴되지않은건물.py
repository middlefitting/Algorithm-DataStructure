def solution(board, skill):
    arr = []
    N = len(board)
    M = len(board[0])
    for i in board:
        for j in i:
            arr.append(j)
    for temp in skill:
        if temp[0] == 1:
            for i in range(temp[1] * M + temp[2], temp[3] * M + temp[4] + 1):
                if temp[2] <= i % M <= temp[4]:
                    arr[i] -= temp[5]
        else:
            for i in range(temp[1] * M + temp[2], temp[3] * M + temp[4] + 1):
                if temp[2] <= i % M <= temp[4]:
                    arr[i] += temp[5]
    answer = 0
    for i in arr:
        if i > 0:
            answer += 1
    return answer

print(solution([[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]], [[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]))
