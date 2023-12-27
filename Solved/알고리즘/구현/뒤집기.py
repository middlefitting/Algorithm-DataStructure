s = str(input())
zero = 0
one = 0
flag = -1
for i in s:
    i = int(i)
    if flag == -1:
        if i == 0:
            flag = 0
        else:
            flag = 1
    elif i == flag:
        continue
    else:
        if flag == 0:
            zero += 1
        else:
            one += 1
        flag = i
if flag == 0:
    zero += 1
else:
    one += 1
print(min(zero, one))
