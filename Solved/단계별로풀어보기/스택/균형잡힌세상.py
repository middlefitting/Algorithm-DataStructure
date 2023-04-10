from collections import deque

if __name__ == "__main__":
    while True:
        s = str(input())
        if s == ".":
            break
        stack = deque([])
        flag = 1
        for i in s:
            if i in "([":
                stack.appendleft(i)
            elif i == ")":
                if stack and stack[0] == "(":
                    stack.popleft()
                else:
                    flag = 0
                    break
            elif i == "]":
                if stack and stack[0] == "[":
                    stack.popleft()
                else:
                    flag = 0
                    break
        if stack:
            flag = 0
        if flag:
            print("yes")
        else:
            print("no")
