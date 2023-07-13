answer = 0
tmp = 0
for i in range(10):
    l, r = map(int, input().split())
    tmp -= l
    tmp += r
    answer = max(answer, tmp)
print(answer)
