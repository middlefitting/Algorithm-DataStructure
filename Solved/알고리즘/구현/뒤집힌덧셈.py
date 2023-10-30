def reverse(raw):
    temp = str(raw)
    result = ""
    for i in range(len(temp)):
        result += temp[len(temp) - 1 - i]
    return int(result)


A, B = map(int, input().split())
A = reverse(A)
B = reverse(B)
print(reverse(A + B))
