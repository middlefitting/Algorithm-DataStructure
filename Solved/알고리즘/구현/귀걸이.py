sena = 0
while True:
    sena += 1
    N = int(input())
    if N == 0:
        break
    d = dict()
    name = [str(input()) for _ in range(N)]
    for i in range(2 * N - 1):
        temp, s = map(str, input().split())
        try:
            d[int(temp)] += 1
        except KeyError:
            d[int(temp)] = 1
    for key, value in d.items():
        if value == 1:
            print(sena, name[key - 1])
