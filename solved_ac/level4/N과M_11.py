N, M = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()
answer = []


def dfs(depth):
    if (depth == M):
        for i in (answer):
            print(i, end=" ")
        print()
        return
    temp_arr = []
    for i in (arr):
        if ((i not in temp_arr) and ((depth == 0) or (i >= answer[-1]))):
            answer.append(i)
            temp_arr.append(i)
            dfs(depth + 1)
            answer.pop()


dfs(0)
ss