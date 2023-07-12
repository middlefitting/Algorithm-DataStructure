answer = 0
tmp = 0
for i in range(4):
    l, r = map(int, input().split())
    tmp -= l
    tmp += r
    answer = max(answer, tmp)
print(answer)

