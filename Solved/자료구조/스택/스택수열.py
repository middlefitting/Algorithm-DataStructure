from collections import deque

if __name__ == "__main__":
    N = int(input())
    arr = deque([i + 1 for i in range(0, N)])
    answer = []
    queue = deque([])
    flag = 1
    for _ in range(N):
        temp = int(input())
        if not queue and arr:
            queue.appendleft(arr.popleft())
            answer.append("+")
        while queue[0] < temp:
            queue.appendleft(arr.popleft())
            answer.append("+")
        if queue[0] == temp:
            queue.popleft()
            answer.append("-")
        else:
            flag = 0
            break
    if flag:
        for i in answer:
            print(i)
    else:
        print("NO")
