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
        if (i not in temp_arr):
            answer.append(i)
            temp_arr.append(i)
            arr.remove(i)
            dfs(depth + 1)
            arr.append(i)
            arr.sort()
            answer.pop()


dfs(0)
