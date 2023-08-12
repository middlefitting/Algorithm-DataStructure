while True:
    N = int(input())
    if N == 0:
        break
    while True:
        root = str(N)
        N = 0
        for i in root:
            N += int(i)
        if N < 10:
            print(N)
            break
