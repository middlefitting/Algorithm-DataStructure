d = int(input())
answer = 0
if d % 5 > 0:
    answer += 1
answer += (d // 5)
print(answer)