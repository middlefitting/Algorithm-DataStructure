N = int(input())
answer = 0
for i in range(N):
    m, d = str(input()).split("-")
    if int(d) <= 90:
        answer += 1
print(answer)