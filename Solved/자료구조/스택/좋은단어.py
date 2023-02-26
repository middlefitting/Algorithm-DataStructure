from collections import deque

if __name__ == "__main__":
    answer = 0
    for _ in range(int(input())):
        arr = list(str(input()))
        queue = deque([])
        for temp in arr:
            if not queue or queue[0] != temp:
                queue.appendleft(temp)
            else:
                queue.popleft()
        if not queue:
            answer += 1
    print(answer)

