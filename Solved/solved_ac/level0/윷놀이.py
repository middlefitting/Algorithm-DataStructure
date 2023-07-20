for _ in range(3):
    result = sum(list(map(int, input().split())))
    if result == 1:
        print("C")
    elif result == 2:
        print("B")
    elif result == 3:
        print("A")
    elif result == 4:
        print("E")
    else:
        print("D")