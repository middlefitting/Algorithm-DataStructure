from collections import deque

if __name__ == "__main__":
    N = int(input())
    answer = 0
    arr = [list(map(int, input().split())) for _ in range(N)]
    arr.sort(key=lambda x: x[0])
    queue = deque([])
    queue.appendleft(arr[0])
    for i in range(1, N):
        if queue[0][1] < arr[i][1]:
            last = i + 1
            answer += (arr[i][0] - queue[0][0]) * queue[0][1]
            queue.popleft()
            queue.appendleft(arr[i])
    queue = deque([])
    queue.appendleft(arr[N - 1])
    for i in range(2, N + 1):
        if queue[0][1] < arr[N - i][1]:
            answer += (queue[0][0] - arr[N - i][0]) * queue[0][1]
            queue.popleft()
            queue.appendleft(arr[N - i])
    arr.sort(key=lambda x: x[1], reverse=True)
    arr2 = []
    big = arr[0][1]
    for temp in arr:
        if temp[1] == big:
            arr2.append(temp)
    arr2.sort(key=lambda x: x[0])
    answer += (arr2[-1][0] - arr2[0][0] + 1) * arr[0][1]
    print(answer)
