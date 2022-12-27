from itertools import combinations

N = int(input())
arr = list(map(int, input().split()))
num = dict()

for i in range(1, N + 1):
    temp_comb = combinations(arr, i)
    for j in temp_comb:
        temp = sum(j)
        num[temp] = 1

i = 1
while True:
    try:
        num[i] += 1
        i += 1
    except:
        print(i)
        break
