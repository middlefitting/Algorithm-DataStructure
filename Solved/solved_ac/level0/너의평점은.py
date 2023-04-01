d = dict()
d["A+"] = 4.5
d["A0"] = 4.0
d["B+"] = 3.5
d["B0"] = 3.0
d["C+"] = 2.5
d["C0"] = 2.0
d["D+"] = 1.5
d["D0"] = 1.0
d["F"] = 0.0

s = 0
c = 0
while True:
    try:
        n, v, r = map(str, input().split())
        if r != 'P':
            s += d[r] * float(v)
            c += float(v)
    except EOFError:
        break
print(s / c)
