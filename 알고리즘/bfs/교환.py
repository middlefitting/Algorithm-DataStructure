from collections import deque

N, K = map(int, input().split())
L = len(str(N))
v = [0] * 1000001
answer = -1
queue = deque([])
queue.append([N, 0])
t = 0
v = set()
while queue:
    x, temp = queue.popleft()
    # 깊이 수준이 다를 때 집합을 초기화
    if temp > t:
        v = set()
        t = temp
    if temp == K:
        answer = max(answer, x)
    if temp > K:
        break
    for i in range(L):
        for j in range(i + 1, L):
            tn = x
            low = x % (10 ** (i + 1)) // (10 ** i)
            big = x % (10 ** (j + 1)) // (10 ** j)
            if j == (L - 1) and low == 0:
                continue
            tn = tn - (big * 10 ** j) - low * 10 ** i + big * 10 ** i + low * 10 ** j
            # 집합의 개수가 갱신되지 않으면 추가되지 않는다. 이미 집합에 있는 내용이므로
            vl = len(v)
            v.add(tn)
            nl = len(v)
            if vl < nl:
                queue.append([tn, temp + 1])

print(answer)
