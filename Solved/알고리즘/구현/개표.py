for i in range(int(input())):
    a = int(input())
    print("++++ " * (a // 5), end="")
    print("|" * (a % 5))
