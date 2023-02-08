N = int(input())
arr = []
alpha = set()
d = dict()
answer = 0
for i in range(N):
    temp = str(input())
    arr.append(temp)
    for k in temp:
        alpha.add(k)
alpha = list(alpha)


def itoa(x):
    num = 0
    for i in x:
        num *= 10
        num += nd[i]
    return num


for i in alpha:
    for j in range(10):
        d[i + str(j)] = 0

for temp in arr:
    for i in range(len(temp)):
        try:
            d[temp[i]] = max(d[temp[i]], len(temp) - i)
        except:
            d[temp[i]] = len(temp) - i
        try:
            d[temp[i] + str((len(temp) - i))] += 1
        except:
            d[temp[i] + str((len(temp) - i))] = 1
nd = dict()
for i in range(len(alpha)):
    n = 9 - i
    max_alpha = alpha[0]
    max_num = 0
    for a in alpha:
        temp_num = 0
        for j in range(10):
            temp_num += d[a + str(j)] * (10**j)
        if temp_num > max_num:
            max_num = temp_num
            max_alpha = a
    nd[max_alpha] = n
    alpha.pop(alpha.index(max_alpha))

for i in arr:
    answer += itoa(i)
print(answer)
