N = int(input())
s = {1, 5, 10, 50}
for i in range(N - 1):
    nex_s = set()
    for e in s:
        nex_s.add(e + 1)
        nex_s.add(e + 5)
        nex_s.add(e + 10)
        nex_s.add(e + 50)
    s = nex_s
print(len(s))
