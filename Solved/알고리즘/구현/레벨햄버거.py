burgers = [0] * 51
pettys = [0] * 51


def getPetty(n, idx):
    if idx == 0:
        return 0
    if n == 0:
        return 1
    if idx == 1:
        return 0
    if idx <= burgers[n - 1] + 1:
        return getPetty(n - 1, idx - 1)
    if idx == burgers[n - 1] + 2:
        return pettys[n - 1] + 1
    if idx < burgers[n] + 1:
        return pettys[n - 1] + 1 + getPetty(n - 1, idx - burgers[n - 1] - 2)
    if idx == burgers[n] + 1:
        return pettys[n]


if __name__ == "__main__":
    pettys[0] = 1
    burgers[0] = 1
    for i in range(1, 51):
        pettys[i] = pettys[i - 1] * 2 + 1
        burgers[i] = burgers[i - 1] * 2 + 3
    n, idx = map(int, input().split())
    print(getPetty(n, idx))

