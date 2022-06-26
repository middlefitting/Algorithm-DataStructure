def definePassword() :
  ConsonantCount = 0
  VowelCount = 0
  possible = False
  for i in range(L) :
    if (answer[i] in ConsonantList) :
      ConsonantCount += 1
    else :
      VowelCount += 1
    if (ConsonantCount >= 1 and VowelCount >= 2) :
      possible = True
      break
  if (possible == True) :
    for i in range(L) :
      print(answer[i], end = "")
    print()

def makePassword(depth, temp) :
  if depth == L :
    definePassword()
    return
  for i in range(temp + 1, C) :
    answer.append(arr[i])
    makePassword(depth + 1, i)
    answer.remove(arr[i])
    

L, C = map(int, input().split())

ConsonantList = ['a', 'e', 'i' , 'o' , 'u']
arr = list(map(str, input().split()))
arr.sort()
answer = []
makePassword(0, -1)

