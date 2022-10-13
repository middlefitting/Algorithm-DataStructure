N = int(input())
A = list(map(int, input().split()))
s = 0
e = N - 1


def divConquer(s, e):
    mid = (s + e) // 2
    if mid == e:
        return A[e] ** 2
    if mid == s:
        return max(A[s] ** 2, (A[s] + A[e]) * min(A[s], A[e]))
    answer = max(divConquer(s, mid), divConquer(mid, e))
    l = mid - 1
    r = mid + 1
    tempSum = A[mid]
    tempMin = A[mid]
    tempAnswer = tempSum * tempMin
    while l >= s and r <= e:
        if l >= s and A[l] >= A[r]:
            tempSum += A[l]
            tempMin = min(tempMin, A[l])
            tempAnswer = tempSum * tempMin
            answer = max(answer, tempAnswer)
            l -= 1
        if r <= e and A[r] > A[l]:
            tempSum += A[r]
            tempMin = min(tempMin, A[r])
            tempAnswer = tempSum * tempMin
            answer = max(answer, tempAnswer)
            r += 1
    while l >= s:
        tempSum += A[l]
        tempMin = min(tempMin, A[l])
        tempAnswer = tempSum * tempMin
        answer = max(answer, tempAnswer)
        l -= 1
    while r <= e:
        tempSum += A[r]
        tempMin = min(tempMin, A[r])
        tempAnswer = tempSum * tempMin
        answer = max(answer, tempAnswer)
        r += 1
    return answer


print(divConquer(s, e))
