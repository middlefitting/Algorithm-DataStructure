N = int(input())
for i in range(N):
    for j in range(i):
        print(" ", end="")
    print("*" * (N - i))
