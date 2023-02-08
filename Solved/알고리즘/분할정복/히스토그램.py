import sys

N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))
s = 0
e = N


def divConquer(s, e):
    mid = (s + e) // 2
    if e == mid:
        return 0
    if s == mid:
        return arr[s]
    answer = max(divConquer(s, mid), divConquer(mid, e))
    l = mid - 1
    r = mid + 1
    temp_min = arr[mid]
    temp_len = 1
    answer = max(answer, temp_min * temp_len)
    while(l >= s) or (r < e):
        if l < s:
            temp_len += 1
            temp_min = min(temp_min, arr[r])
            answer = max(answer, temp_min * temp_len)
            r += 1
        elif r >= e:
            temp_len += 1
            temp_min = min(temp_min, arr[l])
            answer = max(answer, temp_min * temp_len)
            l -= 1
        elif arr[r] >= arr[l]:
            temp_len += 1
            temp_min = min(temp_min, arr[r])
            answer = max(answer, temp_min * temp_len)
            r += 1
        else:
            temp_len += 1
            temp_min = min(temp_min, arr[l])
            answer = max(answer, temp_min * temp_len)
            l -= 1
    return answer


print(divConquer(s, e))

