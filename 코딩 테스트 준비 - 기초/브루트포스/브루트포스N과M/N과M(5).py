def NandM(depth) :
  if (depth == M) :
    for i in range(M) :
      print(answer[i], end=" ")
    print()
    return
  for i in (arr) :
    if ((i in answer) == False) :
      answer.append(i)
      NandM(depth + 1)
      del answer[-1]
    
N, M = map(int, input().split())
answer = []
arr = list(map(int, input().split()))
arr.sort()
NandM(0)