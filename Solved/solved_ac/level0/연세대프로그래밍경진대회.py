def find(n):
    for i in range(1, 101):
        if (1 + i + i ** 2) == n:
            return i


N = int(input())
print(find(N))
