import sys
from collections import deque

stack = deque([])


def push(x):
    stack.appendleft(x)


def pop():
    if len(stack) == 0:
        print(-1)
    else:
        print(stack.popleft())


def size():
    print(len(stack))


def empty():
    if len(stack) == 0:
        print(1)
    else:
        print(0)


def top():
    if len(stack) == 0:
        print(-1)
    else:
        print(stack[0])


N = int(sys.stdin.readline())

for i in range(N):
    ft = list(map(str, sys.stdin.readline().split()))
    if len(ft) == 2:
        locals()[ft[0]](ft[1])
    else:
        locals()[ft[0]]()

