num = int(input())
answer = 0
over = 9
temp = 1
for i in range(1, len(str(num)) + 1) :
  if (i != len(str(num))) :
    answer += i * over
    over *= 10
  else :
    for j in range(i - 1) :
      if(temp == 1) :
        temp = 10
      else :
        temp *= 10
    answer += i * (num - temp + 1) 
print(answer)