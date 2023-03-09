from collections import deque


def renew_flag(flag, c):
    if flag == 0:
        if c == '<':
            return 1
        else:
            return 0
    else:
        if c == '>':
            return 0
        else:
            return 1


if __name__ == "__main__":
    s = str(input())
    stack = deque([])
    flag = 0
    flag_print = 0
    for c in s:
        if c == "<":
            flag = 1
        if flag:
            stack.append(c)
        else:
            if c == " ":
                stack.append(c)
            else:
                stack.appendleft(c)
        if c == ">":
            flag = 0
            flag_print = 1
        if c == " ":
            flag_print = 1
        if flag_print:
            while stack:
                print(stack.popleft(), end = "")
            flag_print = 0
    while stack:
        print(stack.popleft(), end="")
