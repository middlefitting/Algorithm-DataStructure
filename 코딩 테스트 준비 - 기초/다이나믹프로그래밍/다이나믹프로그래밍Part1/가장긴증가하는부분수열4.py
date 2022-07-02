N = int(input())
arr = list(map(int, input().split()))
answer = [1] * N

for i in range(N) :
  for j in range(i) :
    if (arr[i] > arr[j]) :
      answer[i] = max(answer[i], answer[j] + 1)

result = max(answer)
print(result)
compare = arr[answer.index(result)]
findList = [compare]
for i in range(1, result) :
  for j in range(N) :
    temp = N - j - 1
    if((answer[temp] == result - i) and arr[temp] < compare) :
      findList.append(arr[temp])
      compare = arr[temp]
      break
for i in range(1, result + 1) :
  print(findList[result - i], end = " ")
print()