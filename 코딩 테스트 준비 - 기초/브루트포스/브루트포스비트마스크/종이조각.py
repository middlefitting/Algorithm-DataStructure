import sys
sys.setrecursionlimit(10**7)

def findAnswer() :
  answer[0] = max(sum(numArr), answer[0])

def findByRow(temp_row, temp_col) :
  temp = 0
  for i in range(temp_row, row) :
    if(visit[i][temp_col]) :
      visit[i][temp_col] = 0
      temp = temp * 10 + arr[i][temp_col]
      numArr.append(temp)
      calculator(i, temp_col)
      numArr.remove(temp)
    elif(visit[i][temp_col] == 0) :
      for k in range(temp_row, i) :
        visit[k][temp_col] = 1
      return
  for i in range(temp_row, row) :
    visit[i][temp_col] = 1

def findByCol(temp_row, temp_col) :
  temp = 0
  for i in range(temp_col, col) :
    if(visit[temp_row][i]) :
      visit[temp_row][i] = 0
      temp = temp * 10 + arr[temp_row][i]
      numArr.append(temp)
      calculator(temp_row, i)
      numArr.remove(temp)
    elif(visit[temp_row][i] == 0) :
      for k in range(temp_col, i) :
        visit[temp_row][k] = 1
      return
  for i in range(temp_col, col) :
    visit[temp_row][i] = 1

def calculator(x, y) : 
  visitSum = 0
  for i in range(row) :
    visitSum += sum(visit[i])
  if (visitSum == 0) :
    findAnswer()
    return
  
  for j in range(y, col) :
      if(visit[x][j]) :
        findByRow(x, j)
        findByCol(x, j)
        
  for i in range(x + 1, row) :
    for j in range(col) :
      if(visit[i][j]) :
        findByRow(i, j)
        findByCol(i, j)
  # for i in range(row) :
  #   for j in range(col) :
  #     if(visit[i][j]) :
  #       findByRow(i, j)
  #       findByCol(i, j)

row, col = map(int, input().split())
strArr = []
visit = []
answer = [0]
numArr = []
arr =[]
for i in range(row) :
  strArr.append(list(map(str, input())))
for i in range(row) :
  visit.append([1] * col)
  arr.append([0] * col)
for i in range(row) :
  for j in range(col) :
    arr[i][j] = int(strArr[i][j])
calculator(0, 0)
print(answer[0])