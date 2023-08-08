A = 0
B = 0

for _ in range(int(input())):
    a, b = map(int, input().split())
    if a > b:
        A += 1
    if b > a:
        B += 1
print(A, B)