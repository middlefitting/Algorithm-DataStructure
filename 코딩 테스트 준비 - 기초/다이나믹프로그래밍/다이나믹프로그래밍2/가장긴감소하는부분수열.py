N = int(input())
arr = list(map(int, input().split()))
dp_asc = [1] * N
dp_dsc = [1] * N
for i in range(N) :
  for j in range(i) :
    if (arr[i] > arr[j]) :
      if (dp_asc[i] < dp_asc[j] + 1) :
        dp_asc[i] = dp_asc[j] + 1
    if (arr[N - i - 1] > arr[N - j - 1]) :
      if (dp_dsc[N - i - 1] < dp_dsc[N - j - 1] + 1) :
        dp_dsc[N - i - 1] = dp_dsc[N - j - 1] + 1

dp = []
for i in range(N) :
  dp.append(dp_asc[i] + dp_dsc[i] - 1)
print(max(dp))