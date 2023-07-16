N, K = map(int, input().split())
for i in range(2, K):
    if N % i == 0:
        print("BAD", i)
        exit()
print("GOOD")
