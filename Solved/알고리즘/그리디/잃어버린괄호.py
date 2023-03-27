arr = str(input()).split("-")
next = []
for i in range(len(arr)):
    temp = arr[i].split("+")
    c = 0
    for j in temp:
        c += int(j)
    next.append(c)
answer = int(next[0])
for i in range(1, len(next)):
    answer -= int(next[i])
print(answer)
