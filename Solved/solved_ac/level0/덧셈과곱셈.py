A, B = map(int, input().split())


def sum_num(n):
    result = 0
    for i in range(1, n + 1):
        result += i
    return result % 14579


answer = 0
for i in range(A, B + 1):
    if i == A:
        answer = sum_num(A)
    else:
        answer *= sum_num(i)
    answer %= 14579
print(answer)
