while True:
    s = str(input())
    if s == "END":
        break
    for i in range(len(s)):
        print(s[len(s) - i - 1], end="")
    print()
