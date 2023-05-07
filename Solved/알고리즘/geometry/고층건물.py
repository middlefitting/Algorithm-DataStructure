def is_possible(s, e):
    standard = (arr[e] - arr[s]) / (e - s)
    for i in range(s + 1, e):
        if (arr[e] - arr[i]) / (e - i) <= standard:
            return False
    return True


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    answer = 0
    for i in range(N):
        temp = 0
        for j in range(N):
            if i == j:
                continue
            if i > j:
                if is_possible(j, i):
                    temp += 1
            if i < j:
                if is_possible(i, j):
                    temp += 1
        answer = max(answer, temp)
    print(answer)
