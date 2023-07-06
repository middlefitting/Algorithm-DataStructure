N = int(input())
for i in range(1, N + 1):
    print("*" * i, end="")
    print(" " * (N - i) * 2, end="")
    print("*" * i)
for j in range(1, N + 1):
    i = N - j
    print("*" * i, end="")
    print(" " * (N - i) * 2, end="")
    print("*" * i)