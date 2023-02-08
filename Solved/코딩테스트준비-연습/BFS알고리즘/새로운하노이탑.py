import math
from collections import deque

a_arr = list(map(str, input().split()))
num1 = int(a_arr[0])
if num1 == 0:
    a_arr.append("")
b_arr = list(map(str, input().split()))
num2 = int(b_arr[0])
if num2 == 0:
    b_arr.append("")
c_arr = list(map(str, input().split()))
num3 = int(c_arr[0])
if num3 == 0:
    c_arr.append("")
# hanoi = dict()
queue = deque([])
queue.append(['a' + a_arr[1], 'b' + b_arr[1], 'c' + c_arr[1], 0])
# hanoi['a' + a_arr[1] + 'b' + b_arr[1] + 'c' + c_arr[1]] = 1

answer = math.inf
hanoi = set()
hanoi.add('a' + a_arr[1] + 'b' + b_arr[1] + 'c' + c_arr[1])

while queue:
    # print(hanoi)
    a, b, c, n = queue.popleft()
    # print(a, b, c, n)
    l = len(hanoi)
    if ('B' not in a) and ('C' not in a) and ('A' not in b) and ('C' not in b) and ('A' not in c) and ('B' not in c):
        answer = min(answer, n)
        break
    if len(a) > 1:
        hanoi.add(a[:-1] + b + a[-1] + c)
        if len(hanoi) != l:
            queue.append([a[:-1], b + a[-1], c, n + 1])
            l += 1
        hanoi.add(a[:-1] + b + c + a[-1])
        if len(hanoi) != l:
            queue.append([a[:-1], b, c + a[-1], n + 1])
            l += 1
    if len(b) > 1:
        hanoi.add(a + b[-1] + b[:-1] + c)
        if len(hanoi) != l:
            queue.append([a + b[-1], b[:-1], c, n + 1])
            l += 1
        hanoi.add(a + b[:-1] + c + b[-1])
        if len(hanoi) != l:
            queue.append([a, b[:-1], c + b[-1], n + 1])
            l += 1
    if len(c) > 1:
        hanoi.add(a + c[-1] + b + c[:-1])
        if len(hanoi) != l:
            queue.append([a + c[-1], b, c[:-1], n + 1])
            l += 1
        hanoi.add(a + b + c[-1] + c[:-1])
        if len(hanoi) != l:
            queue.append([a, b + c[-1], c[:-1], n + 1])
            l += 1
print(answer)