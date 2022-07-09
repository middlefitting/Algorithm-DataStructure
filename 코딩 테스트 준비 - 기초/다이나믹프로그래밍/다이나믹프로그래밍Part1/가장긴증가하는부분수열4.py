N = int(input())
arr = list(map(int, input().split()))
answer = [1] * N

for i in range(N) :
  for j in range(i) :
    if (arr[i] > arr[j]) :
      answer[i] = max(answer[i], answer[j] + 1)

result = max(answer)
answer_list = [arr[answer.index(result)]]
temp = result
for i in range(result - 1):
  for j in range(answer.index(result)):
    if((answer[j] == (temp - 1)) and arr[j] < answer_list[i]) :
      answer_list.append(arr[j])
      temp = answer[j]
      break
print(result)
answer_list.reverse()
for i in range(result - 1) :
  print(answer_list[i], end = " ")
print(answer_list[result - 1])