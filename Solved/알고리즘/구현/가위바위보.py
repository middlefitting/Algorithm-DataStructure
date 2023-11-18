for _ in range(int(input())):
    a = 0
    b = 0
    for __ in range(int(input())):
        at, bt = map(str, input().split())
        if at == bt:
            continue
        elif (at == 'R' and bt == 'S') or (at == 'S' and bt == 'P') or (at == 'P' and bt == 'R'):
            a += 1
        else:
            b += 1
    if a == b:
        print("TIE")
    elif a > b:
        print("Player 1")
    else:
        print("Player 2")