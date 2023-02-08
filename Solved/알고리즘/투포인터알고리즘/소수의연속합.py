N = int(input())
is_s = [1] * 4000001
is_s[1] = 0
is_s[0] = 0


for i in range(2, 4000001):
    if is_s[i]:
        temp = 2
        while True:
            if temp * i > 4000000:
                break
            is_s[i * temp] = 0
            temp += 1
arr = []
for i in range(2, 4000001):
    if is_s[i]:
        arr.append(i)

count = 0
final = len(arr)
S = 0
s = -1
e = -1
while True:
    # if ((e == final) and (s == final)):
    #     break
    if e == final:
        s += 1
        if s < final:
            S -= arr[s]
        else:
            break
    elif S < N:
        e += 1
        if e < final:
            S += arr[e]
    elif S >= N:
        s += 1
        if s < final:
            S -= arr[s]
    if S == N:
        count += 1
print(count)
