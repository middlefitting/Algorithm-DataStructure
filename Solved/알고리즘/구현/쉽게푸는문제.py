def between_sum(s, e):
    arr = []
    temp = 1
    result = 0
    while True:
        for i in range(temp):
            arr.append(temp)
        temp += 1
        if len(arr) >= e:
            break
    for i in range(s - 1, e):
        result += arr[i]
    return result


A, B = map(int, input().split())
print(between_sum(A, B))
