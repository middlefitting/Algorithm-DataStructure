for _ in range(int(input())):
    N = int(input())
    arr = [False] * (N + 1)
    for i in range(1, N + 1):
        idx = 1
        while idx * i <= N:
            arr[idx * i] = not arr[idx * i]
            idx += 1
    print(sum(arr))
