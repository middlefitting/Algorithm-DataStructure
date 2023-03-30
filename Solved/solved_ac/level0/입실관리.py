for _ in range(int(input())):
    s = str(input())
    for i in s:
        if ord(i) < 97:
            print(chr(ord(i) + 32), end="")
        else:
            print(i, end="")
    print()
