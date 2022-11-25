N = int(input())
M = int(input())
arr = list(map(int, input().split()))
arr.sort()
len_arr = []
for i in range(N - 1):
    len_arr.append(arr[i + 1] - arr[i])
len_arr.sort()
for i in range(M - 1):
    try:
        len_arr.pop()
    except:
        len_arr = len_arr
print(sum(len_arr))
