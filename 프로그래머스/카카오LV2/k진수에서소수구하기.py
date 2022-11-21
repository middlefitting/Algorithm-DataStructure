import string

tmp = string.digits+string.ascii_lowercase


def convert(num, base) :
    q, r = divmod(num, base)
    if q == 0 :
        return tmp[r]
    else:
        return convert(q, base) + tmp[r]


def sosu(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num / i == int(num / i):
            return False
    return True


def possible(i, j, num, temp):
    l = len(num)

    for x in str(temp):
        if x == '0':
            return False
    if i == 0:
        if j == -1:
            if l == 1 or num[1] == '0':
                return True
        else:
            if j == (l - 1) or num[j + 1] == '0':
                return True

    elif i == (l - 1):
        if num[i - 1] == '0':
            return True

    else:
        if j == -1:
            if num[i - 1] == '0' and num[i + 1] == '0':
                return True
        elif j == l - 1:
            if num[i - 1] == '0':
                return True
        else:
            if num[i - 1] == '0' and num[j + 1] == '0':
                return True
    return False


def solution(n, k):
    answer = []
    num = str(convert(n, k))
    for i in range(len(num)):
        temp = int(num[i])
        if temp == 0:
            continue
        if sosu(temp) and possible(i, -1, num, temp):
            answer.append(temp)
        for j in range(i + 1, len(num)):
            temp *= 10
            temp += int(num[j])
            if sosu(temp) and possible(i, j, num, temp):
                answer.append(temp)
    return len(answer)

print(solution(110011, 10))