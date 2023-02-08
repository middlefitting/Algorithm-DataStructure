for _ in range(3):
    N = int(input())
    num = 0;
    for _ in range(N):
        num += int(input())
    if num == 0:
        print('0')
    elif num < 0:
        print('-')
    else:
        print('+')
