a, b, c = map(int, input().split())

print(max(abs(a - b) - 1, abs(c - b) - 1))
