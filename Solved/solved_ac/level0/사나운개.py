def attak(x, y, n):
    count = 0
    while True:
        count += x
        if n <= count:
            return 1
        count += y
        if n <= count:
            return 0


x, y, x2, y2 = map(int, input().split())
delivers = list(map(int, input().split()))
for i in delivers:
    print(attak(x, y, i) + attak(x2, y2, i))

