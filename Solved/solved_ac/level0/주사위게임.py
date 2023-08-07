answer = []
for _ in range(int(input())):
    a, b, c = map(int, input().split())
    if a == b == c:
        answer.append(10000 + a * 1000)
    elif a == b or b == c or a == c:
        arr = [a, b, c]
        arr.sort()
        answer.append(1000 + arr[1] * 100)
    else:
        arr = [a, b, c]
        arr.sort()
        answer.append(arr[2] * 100)
print(max(answer))
