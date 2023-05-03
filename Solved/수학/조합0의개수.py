def find_n(n, s):
    cnt = 0
    while n >= s:
        cnt += n // s
        n //= s
    return cnt


if __name__ == "__main__":
    N, M = map(int, input().split())
    two = find_n(N, 2) - find_n(N - M, 2) - find_n(M, 2)
    five = find_n(N, 5) - find_n(N - M, 5) - find_n(M, 5)
    answer = min(two, five)
    if answer < 0:
        print(0)
    else:
        print(answer)

