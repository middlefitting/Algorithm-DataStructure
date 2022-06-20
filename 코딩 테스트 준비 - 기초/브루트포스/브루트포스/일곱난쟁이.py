def find_answer(arr, answer, depth, now) :
  if (depth == 7) :
    if (sum(answer) == 100) :
      for i in range(7) :
        print(answer[i])
      exit(0)
  else :
    for i in range(now + 1, 9) :
      answer.append(arr[i])
      find_answer(arr, answer, depth + 1, i)
      answer.remove(arr[i])

arr = list()
answer = list()
for i in range(9) :
  arr.append(int(input()))
arr.sort()
find_answer(arr, answer, 0, -1)

