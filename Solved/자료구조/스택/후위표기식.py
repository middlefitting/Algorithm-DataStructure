from collections import deque

if __name__ == "__main__":
    arr = list(str(input()))
    queue = deque([])

    for temp in arr:
        if temp in "(+-*/":
            if not queue:
                queue.appendleft(temp)
            elif queue[0] == "(":
                queue.appendleft(temp)
            elif temp == "(":
                queue.appendleft(temp)
            elif temp in "+-":
                while queue:
                    if queue[0] == "(":
                        break
                    print(queue.popleft(), end="")
                queue.appendleft(temp)
            elif temp in "*/":
                while queue:
                    if queue[0] in "(+-":
                        break
                    print(queue.popleft(), end="")
                queue.appendleft(temp)
        elif temp == ")":
            find = queue.popleft()
            while find != "(":
                print(find, end="")
                find = queue.popleft()
        else:
            print(temp, end="")
    while queue:
        print(queue.popleft(), end="")

