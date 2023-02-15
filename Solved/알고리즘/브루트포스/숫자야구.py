def strike(answer, compare):
    result = 0
    for i in range(3):
        if answer[i] == compare[i]:
            result += 1
    return result


def ball(answer, compare):
    result = 0
    for i in range(3):
        if (answer[i] != compare[i]) and (compare[i] in answer):
            result += 1
    return result


def is_possible(temp, arr):
    for num, s, b in arr:
        if strike(temp, num) != int(s) or ball(temp, num) != int(b):
            return 0
    return 1


count = 0
arr = []
for i in range(int(input())):
    arr.append(list(map(str, input().split())))

for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i == j or i == k or j == k:
                continue
            temp = str(i) + str(j) + str(k)
            if is_possible(temp, arr):
                count += 1
print(count)
