N, M, K = map(int, input().split())

if K > 0:
    if N > 2 * M:
        c = (N - 2 * M)
        K -= c
        N -= c
    else:
        c = (2 * M - N) // 2
        K -= c
        M -= c
if K > 0:
    if N > 2 * M:
        c = (N - 2 * M)
        K -= c
        N -= c
    else:
        c = (2 * M - N)
        K -= c
        M -= c
while K > 0:
    K -= 3
    N -= 2
    M -= 1
answer = 0
if N > 0 and M > 0:
    answer = min(N // 2, M)
print(answer)