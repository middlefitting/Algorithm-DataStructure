while True:
    N = str(input())
    if N == '0':
        break
    N = float(N)
    print('%.2f' % (1 + N + N ** 2 + N ** 3 + N ** 4))
