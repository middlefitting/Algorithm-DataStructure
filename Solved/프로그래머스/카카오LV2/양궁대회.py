find = [False]
answer = [0] * 11
score = [0]


def dfs(depth, info, n, temp):
    if depth == 11:
        pitch = 0
        lion = 0
        for i in range(11):
            if temp[i] == 0 and info[i] == 0:
                continue
            elif temp[i] > info[i]:
                lion += (10 - i)
            else:
                pitch += (10 - i)
        if lion > pitch:
            find[0] = True
            if score[0] < (lion - pitch):
                print(score)
                score[0] = lion - pitch
                if n > 0:
                    temp[10] += n
                for i in range(11):
                    answer[i] = temp[i]

    for i in range(depth, 11):
        if n > info[10 - i]:
            temp[10 - i] = info[10 - i] + 1
            dfs(i + 1, info, n - info[10 - i] - 1, temp)
            temp[10 - i] = 0
        if n == 0:
            dfs(i + 1, info, n, temp)


def solution(n, info):
    temp = [0] * 11
    dfs(0, info, n, temp)
    if not find[0]:
        return [-1]
    else:
        return answer


print(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]))
