import sys

def find_link() :
  i = 0
  temp = [1]
  result[i].append(1)
  answer.append(1)
  while(len(answer) != N[0]) :
    while(len(temp) != 0) :
      now = temp[0]
      temp.remove(now)
      for j in (vector[now]) :
        if ((j in answer) == 0) :
          result[i].append(j)
          answer.append(j)
          temp.append(j)

    for j in range(1, N[0] + 1) :
      if ((j in answer) == 0) :
        temp.append(j)
        answer.append(j)
        result[i + 1].append(j)
        break
    i += 1
    
N = [0]
M = [0]
N[0], M[0] = map(int, sys.stdin.readline().split())
vector = [[] for _ in range(N[0] + 1)]
for i in range(M[0]) :
  a, b = map(int, sys.stdin.readline().split())
  vector[a].append(b)
  vector[b].append(a)

answer = []
result = [[] for _ in range(N[0])]
find_link()
score = 0
for i in (result) :
  if (len(i) != 0) :
    score += 1
print(score)