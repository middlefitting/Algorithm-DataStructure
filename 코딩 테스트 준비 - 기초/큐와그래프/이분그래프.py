import sys
sys.setrecursionlimit(10 ** 5)

def find_answer(temp) :
  for n in (vector[temp]) :
    if(red_blue[n] == 0) :
      if (red_blue[temp] == 1) :
        red_blue[n] = 2
      elif (red_blue[temp] == 2) :
        red_blue[n] = 1
      result = find_answer(n)
      if (result == 0) :
        return (0)
    elif(red_blue[n] == red_blue[temp]) :
      return(0)
  return(1)

K = int(sys.stdin.readline())
for _ in range (K) :
  V, E = map(int, sys.stdin.readline().split())
  vector = [[] for _ in range(V + 1)]
  for i in range(E) :
    x, y = map(int, sys.stdin.readline().split())
    vector[x].append(y)
    vector[y].append(x)
  
  red_blue = [0] * (V + 1)
  for i in range(1, V + 1) :
    if (red_blue[i] == 0) :
      red_blue[i] = 1
      result = find_answer(i)
      if (result == 0) :
        break
  if (result) :
    print("YES")
  else :
    print("NO")