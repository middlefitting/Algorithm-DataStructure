def circul(x):
    result = 0
    for i in range(1, x + 1):
        result += i
    return result


def is_possible(arr, num):
    for i in arr:
        for j in arr:
            for k in arr:
                if i + j + k == num:
                    return 1
    return 0


arr = []
temp = 1
i = 1

while temp <= 1000:
    arr.append(temp)
    i += 1
    temp = circul(i)

for _ in range(int(input())):
    num = int(input())
    print(is_possible(arr, num))

