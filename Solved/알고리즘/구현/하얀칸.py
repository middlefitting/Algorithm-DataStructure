answer = 0
for i in range(8):
    temp = str(input())
    for j in range(8):
        if (not (i + j) % 2) and temp[j] == 'F':
            answer += 1
print(answer)
