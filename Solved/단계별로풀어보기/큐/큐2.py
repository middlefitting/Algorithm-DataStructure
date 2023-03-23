import sys
from collections import deque

if __name__ == "__main__":
    queue = deque([])
    for i in range(int(sys.stdin.readline())):
        temp = list(map(str, sys.stdin.readline().split()))
        if temp[0] == "push":
            queue.append(temp[1])
        if temp[0] == "pop":
            if queue:
                print(queue.popleft())
            else:
                print(-1)
        if temp[0] == "size":
            print(len(queue))
        if temp[0] == "empty":
            if len(queue) == 0:
                print(1)
            else:
                print(0)
        if temp[0] == "front":
            if queue:
                print(queue[0])
            else:
                print(-1)
        if temp[0] == "back":
            if queue:
                x = queue.pop()
                print(x)
                queue.append(x)
            else:
                print(-1)
