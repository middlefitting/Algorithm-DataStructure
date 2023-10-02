N = int(input())
for i in range(1, N + 1):
    if i == N or i == 1:
        print(" " * (N - i), end="")
        print("*" * (2 * i - 1))
    else:
        print(" " * (N - i), end="")
        print("*", end="")
        print(" " * (2 * (i - 1) - 1), end="")
        print("*")

