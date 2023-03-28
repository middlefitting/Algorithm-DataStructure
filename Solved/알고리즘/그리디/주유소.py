import math
from collections import deque

N = int(input())
l = deque(list(map(int, input().split())))
node = deque(list(map(int, input().split())))
answer = 0
v = math.inf
while l:
    t_m = node.popleft()
    t_l = l.popleft()
    if t_m < v:
        v = t_m
    answer += v * t_l
print(answer)
