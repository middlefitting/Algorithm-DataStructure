from collections import deque


def operation(b, a, oper):
    if oper == "+":
        return a + b
    elif oper == "-":
        return a - b
    elif oper == "*":
        return a * b
    elif oper == "/":
        return a / b


if __name__ == "__main__":
    N = int(input())
    sentence = str(input())
    d = dict()
    queue = deque()
    for i in range(65, 65 + N):
        d[chr(i)] = int(input())
    for temp in sentence:
        if 65 <= ord(temp) <= 90:
            queue.appendleft(d[temp])
        else:
            queue.appendleft(operation(queue.popleft(), queue.popleft(), temp))
    print(f'{queue.popleft():.2f}')
