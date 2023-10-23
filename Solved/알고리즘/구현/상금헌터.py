a = []
b = []
money1 = [500, 300, 200, 50, 30, 10]
money2 = [512, 256, 128, 64, 32]
for i in range(1, 6 + 1):
    for j in range(i):
        a.append(money1[i - 1])

for i in range(1, 5 + 1):
    for j in range(2 ** (i - 1)):
        b.append(money2[i - 1])

for i in range(int(input())):
    temp = 0
    x, y = map(int, input().split())
    try:
        if x != 0:
            temp += a[x - 1]
    except:
        temp = temp
    try:
        if y != 0:
            temp += b[y - 1]
    except:
        temp = temp
    print(temp * 10000)