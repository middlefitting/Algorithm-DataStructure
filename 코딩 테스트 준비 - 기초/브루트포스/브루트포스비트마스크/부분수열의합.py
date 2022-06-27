def countAnswer(depth) :
  if (0 < depth <= N) :
    if (sum(answer) == S) :
      count[0] += 1
  for i in range(depth, N) :
    answer.append(arr[i])
    countAnswer(i + 1)
    answer.remove(arr[i])
      
N, S = map(int, input().split())
arr = list(map(int, input().split()))
count = [0]
answer = []
countAnswer(0)
print(count[0])