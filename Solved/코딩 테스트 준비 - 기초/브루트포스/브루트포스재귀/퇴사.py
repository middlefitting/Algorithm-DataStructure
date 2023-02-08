def findProfit(temp, answer) :
  if (answer >= max[0]) :
    max[0] = answer
  for i in range(temp, N) :
    if(i + arr[i][0] <= N) :
      findProfit(i + arr[i][0], answer + arr[i][1])

N = int(input())
arr = []
max = [0]

for i in range(N) :
  arr.append(list(map(int, input().split())))
findProfit(0, 0)
print(max[0])
