N = int(input())
arr = list(map(int, input().split()))
answer = [0]


def dfs(energy):
    if len(arr) == 2:
        answer[0] = max(answer[0], energy)
        return
    for i in range(1, len(arr) - 1):
        temp = arr[i]
        temp_energy = energy + arr[i - 1] * arr[i + 1]
        arr.pop(i)
        dfs(temp_energy)
        arr.insert(i, temp)


dfs(0)
print(answer[0])
