def find_num(num) :
  for i in range(1, 4) :
    num = num - i
    if (num > 0) :
      find_num(num)
    if (num == 0) :
      answer[0] += 1
    num = num + i

T = int(input())
for i in range(T) :
  answer = [0]
  num = int(input())
  find_num(num)
  print(answer[0])
    