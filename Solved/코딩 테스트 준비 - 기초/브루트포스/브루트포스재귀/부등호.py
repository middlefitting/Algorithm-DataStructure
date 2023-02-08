def findArr(depth, num, find, answer) :
  if (depth == N + 1) :
    find[0] = 1
  if (not find[0]) :
    for i in range(10) :
      if(not find[0] and depth == 0) :
        answer.append(num[i])
        findArr(depth + 1, num, find, answer)
        if(not find[0]):
          answer.remove(num[i])
      elif(not find[0] and ((num[i] in answer) == False)) :
        if (arr[depth - 1] == '>' and num[i] < answer[depth - 1]):
          answer.append(num[i])
          findArr(depth + 1, num, find, answer)
          if(not find[0]):
            answer.remove(num[i])
        if (arr[depth - 1] == '<' and num[i] > answer[depth - 1]):
          answer.append(num[i])
          findArr(depth + 1, num, find, answer)
          if(not find[0]):
            answer.remove(num[i])

N = int(input())
arr = list(map(str, input().split()))
num = [0,1,2,3,4,5,6,7,8,9]
numReverse = [9,8,7,6,5,4,3,2,1,0]
findMax = [0]
findMin = [0]
maxArr = []
minArr = []
findArr(0, numReverse, findMax, maxArr)
findArr(0, num, findMin, minArr)
for i in range(N + 1) :
  print(maxArr[i], end="")
print()
for i in range(N + 1) :
  print(minArr[i], end="")
print()