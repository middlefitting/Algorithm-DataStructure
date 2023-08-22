N = int(input())
for i in range(1, N + 1):
    print(" " * (N - i), end="")
    print("*" * i)
for i in range(1, N):
    print(" " * i, end="")
    print("*" * (N - i))

