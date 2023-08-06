for _ in range(int(input())):
    n = int(input())
    print(n // 25, end=" ")
    n %= 25
    print(n // 10, end=" ")
    n %= 10
    print(n // 5, end=" ")
    n %= 5
    print(n)
