N = int(input())
for i in range(1, N + 1):
    if i == 1:
        print(" " * (N - 1),end="")
        print("*")
    else:
        print(" " * (N - i), end="")
        print("*", end="")
        print(" " * (2 * (i - 1) - 1), end="")
        print("*")
