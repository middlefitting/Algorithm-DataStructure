from collections import deque

if __name__ == "__main__":
    for _ in range(int(input())):
        queue = deque([])
        arr = list(str(input()))
        close = 0
        flag = 1
        for temp in arr:
            if temp == "(":
                queue.appendleft(temp)
            else:
                close += 1
                while queue and close != 0:
                    if queue.popleft() == "(":
                        close -= 1
                    else:
                        close += 1
                if close != 0:
                    flag = 0
                    print("NO")
                    break
        if flag:
            if close == 0 and not queue:
                print("YES")
            else:
                print("NO")

