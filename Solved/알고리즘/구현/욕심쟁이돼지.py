N = int(input())
for _ in range(N):
    T = int(input())
    arr = list(map(int, input().split()))
    answer = 1
    while True:
        if sum(arr) > T:
            break
        temp = arr.copy()
        for i in range(6):
            temp[i] = arr[(i + 5) % 6] + arr[(i + 1) % 6] + arr[(i + 3) % 6] + arr[i]
        arr = temp
        answer += 1
    print(answer)