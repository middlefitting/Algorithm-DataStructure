T = int(input())
answer = 0

for i in range (T) :
  num = i + 1
  n = 1
  numBy = num ** 0.5
  while (n <= numBy) :
    if (num % n == 0) :
      answer += n
      if (n != numBy) :
        answer += num / n
    n += 1

print(answer)