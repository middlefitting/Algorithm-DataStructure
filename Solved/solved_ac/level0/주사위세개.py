a, b, c = map(int, input().split())
if a == b == c:
    print(10000 + a * 1000)
elif a == b or a == c or b == c:
    temp = 0
    if a == b:
        temp = a
    if b == c:
        temp = b
    if a == c:
        temp = a
    print(1000 + temp * 100)
else:
    temp = max(a, b, c)
    print(temp * 100)