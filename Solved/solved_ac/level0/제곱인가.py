N = int(input())
if N == 1:
    print(1)
else:
    while N != 1:
        if N % 2 != 0:
            print(0)
            exit()
        N = N // 2
    print(1)
