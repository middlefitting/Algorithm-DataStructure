def aeratos():
    arr = [True] * 10000001
    arr[0] = False
    arr[1] = False

    for i in range(2, 10000001):
        if not arr[i]:
            continue
        mul = 2
        while True:
            if i * mul > 10000000:
                break
            arr[i * mul] = False
            mul += 1
    return arr


def dfs(sosu, numbers, s, v, temp, depth):
    if depth > len(numbers):
        if not temp:
            return
        num = int(temp)
        if sosu[num]:
            s.add(num)
        return
    for i in range(0, len(numbers)):
        if v[i]:
            continue
        v[i] = True
        dfs(sosu, numbers, s, v, temp + numbers[i], depth + 1)
        v[i] = False
    dfs(sosu, numbers, s, v, temp, depth + 1)


def brute(sosu, numbers):
    answer = set()
    v = [False] * len(numbers)
    s = set()
    dfs(sosu, numbers, s, v, "", 0)
    return len(s)


def solution(numbers):
    sosu = aeratos()
    return brute(sosu, numbers)


print(solution("1111"))