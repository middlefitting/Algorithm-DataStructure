a, b, c = map(int, input().split())
d, e, f = map(int, input().split())

man = d - a
if b > e:
    man -= 1
elif b == e and c > f:
    man -= 1
se = 1 + d - a
yun = d - a
print(man)
print(se)
print(yun)