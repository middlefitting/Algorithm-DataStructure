while True:
    x = int(input())
    if x == 0:
        break
    for i in range(x):
        for j in range(i + 1):
            print("*", end="")
        print()
