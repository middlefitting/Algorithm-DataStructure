from collections import deque

if __name__ == "__main__":
    stack_a = deque(list(str(input())))
    stack_b = deque([])
    answer = 0
    bar = 0
    while stack_a:
        temp = stack_a.popleft()
        if temp == "(":
            if stack_a[0] != ")":
                bar += 1
                answer += 1
        else:
            if stack_b[0] == "(":
                answer += bar
            else:
                bar -= 1
        stack_b.appendleft(temp)
    print(answer)

