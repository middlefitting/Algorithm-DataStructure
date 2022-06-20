def NandM(depth) :
  if (depth == M) :
    for i in range(M) :
      print(answer[i], end=" ")
    print()
    return
  for i in range(1, N + 1) :
    if ((i in answer) == False) :
      answer.append(i)
      NandM(depth + 1)
      answer.remove(i)
    
N, M = map(int, input().split())
arr = []
answer = []

for i in range(1, N + 1) :
  arr.append(i)
NandM(0)
