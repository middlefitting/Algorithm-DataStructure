import sys
N = int(sys.stdin.readline())
len_arr = []
star = []
mst = [-1] * N


def find_length(a, b):
    return ((a[0] - b[0])**2 + (a[1] - b[1])**2) ** 0.5


def find(a):
    if mst[a] < 0:
        return a
    mst[a] = find(mst[a])
    return mst[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    mst[b] = a
    return True


for i in range(N):
    star.append(list(map(float, sys.stdin.readline().split())))

for i in range(N):
    for j in range(i + 1, N):
        len_arr.append([i, j, find_length(star[i], star[j])])

len_arr.sort(key=lambda x:x[2])

count = 0
answer = 0.0
for temp in len_arr:
    if merge(temp[0], temp[1]):
        count += 1
        answer += temp[2]
    if count == (N - 1):
        break
print(answer)