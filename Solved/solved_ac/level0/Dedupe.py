for i in range(int(input())):
    temp = str(input())
    for j in range(len(temp)):
        if j == 0:
            print(temp[j], end="")
        elif temp[j] != temp[j - 1]:
            print(temp[j], end="")
    print()
