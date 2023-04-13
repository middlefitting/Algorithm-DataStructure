if __name__ == "__main__":
    s = str(input())
    for i in s:
        if ord('a') <= ord(i) <= ord('z'):
            n = ord(i) + 13
            if n > 122:
                n -= 26
            print(chr(n), end="")
        elif ord('A') <= ord(i) <= ord('Z'):
            n = ord(i) + 13
            if n > 90:
                n -= 26
            print(chr(n), end="")
        else:
            print(i, end="")
    print("")
