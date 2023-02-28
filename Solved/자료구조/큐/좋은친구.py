from collections import deque

if __name__ == "__main__":
    N, K = map(int, input().split())
    arr = [[] for _ in range(21)]
    queue = []
    answer = 0
    for i in range(N):
        temp = str(input())
        arr[len(temp)].append(i)
    for a in arr:
        a.sort()
    for a in arr:
        queue.append(deque(a))
    for q in queue:
        find = deque([])
        while True:
            if find:
                temp = find.popleft()
            elif q:
                temp = q.popleft()
            else:
                break
            while q:
                compare = q.popleft()
                if temp - K <= compare <= temp + K:
                    find.append(compare)
                else:
                    q.appendleft(compare)
                    break
                answer += len(find)
    print(answer)
