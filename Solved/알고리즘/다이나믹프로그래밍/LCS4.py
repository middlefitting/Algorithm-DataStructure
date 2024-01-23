def find_position(lis, value):
    left, right = 0, len(lis) - 1
    while left <= right:
        mid = (left + right) // 2
        if lis[mid] == value:
            return mid
        elif lis[mid] < value:
            left = mid + 1
        else:
            right = mid - 1
    return left


N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
d = dict()
for i in range(N):
    d[A[i]] = i
for i in range(N):
    B[i] = d[B[i]]

lis = []
for i in B:
    if not lis or i > lis[-1]:
        lis.append(i)
    else:
        lis[find_position(lis, i)] = i
print(len(lis))

