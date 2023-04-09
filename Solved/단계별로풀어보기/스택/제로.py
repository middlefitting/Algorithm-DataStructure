from collections import deque

stack = deque([])
answer = 0
for i in range(int(input())):
    temp = int(input())
    if temp == 0:
        stack.popleft()
    else:
        stack.appendleft(temp)
while stack:
    answer += stack.popleft()
print(answer)