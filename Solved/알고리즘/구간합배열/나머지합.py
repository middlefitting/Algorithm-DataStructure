if __name__ == "__main__":
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    d = dict()
    answer = 0
    pSum = [0] * N
    pSum[0] = arr[0]
    for i in range(1, N):
        pSum[i] = pSum[i - 1]
        pSum[i] += arr[i]
    d[0] = 1
    for n in pSum:
        k = n % K
        try:
            d[k] += 1
        except KeyError:
            d[k] = 1
    for k, v in d.items():
        answer += ((v - 1) * v) // 2
    print(answer)
