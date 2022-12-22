from collections import deque

v = dict()
start = list(map(int, input().split()))
start.sort(reverse=True)
queue = deque([start])
answer = 0
while queue:
    temp = queue.popleft()
    a, b, c = temp
    if a == b == c:
        answer = 1
        break
    if a > b:
        t = [a - b, b + b, c]
        t.sort(reverse=True)
        try:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1]
        except:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1] = 1
            queue.append(t)
    if b > c:
        t = [a, b - c, c + c]
        t.sort(reverse=True)
        try:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1]
        except:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1] = 1
            queue.append(t)
    if a > c:
        t = [a - c, b, c + c]
        t.sort(reverse=True)
        try:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1]
        except:
            v[(t[0] - 1) * 500 * 500 + (t[1] - 1) * 500 + c - 1] = 1
            queue.append(t)
print(answer)


