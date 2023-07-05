N = int(input())
for i in range(N):
    for j in range(i):
        print(" ", end="")
    print("*" * ((2 * (N - i)) - 1))

