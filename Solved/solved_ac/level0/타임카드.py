for i in range(3):
    a, b, c, d, e, f = map(int, input().split())
    r1, r2, r3 = d - a, e - b, f - c
    if r3 < 0:
        r2 -= 1
        r3 += 60
    if r2 < 0:
        r1 -= 1
        r2 += 60
    print(r1, r2, r3)
