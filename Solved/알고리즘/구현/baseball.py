for _ in range(int(input())):
    y = 0
    k = 0
    for i in range(9):
        a, b = map(int, input().split())
        y += a
        k += b
    if y > k:
        print("Yonsei")
    elif y == k:
        print("Draw")
    else:
        print("Korea")