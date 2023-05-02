for _ in range(int(input())):
    a, b = map(int, input().split())
    ind = 2
    answer = 1
    while ind <= a and ind <= b:
        if a % ind == 0 and b % ind == 0:
            a //= ind
            b //= ind
            answer *= ind
        else:
            ind += 1
    print(a * b * answer)
