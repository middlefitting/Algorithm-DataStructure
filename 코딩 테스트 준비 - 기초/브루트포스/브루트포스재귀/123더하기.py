def count_num(Num, now) :
  for i in (arr) :
    now += i
    if (now < Num) :
      count_num(Num, now)
    if (now == Num) :
      count[0] += 1

T = int(input())

for i in range(T) :
  Num = int(input())
  arr = []
  count = [0]
  for j in range(1, Num + 1) :
    arr.append(j)
  count_num(Num, 0)
  print(count[0])
  