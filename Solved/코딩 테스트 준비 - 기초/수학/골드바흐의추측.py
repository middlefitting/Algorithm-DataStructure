def prime(n) :
  for i in range(2, int(n ** 0.5) + 1) :
    if (n % i == 0) :
      return (0)
  return(1)
  
while (1) :
  num = int(input())
  max = num - 3
  
  if (num == 0) :
    break
  
  for i in range(0, max) :
    now = max - i
    if (now == 2) :
      print ( "Goldbach's conjecture is wrong.")
      break
    if(prime(now)) :
      if(prime(num - now)) :
        print(str(num) + " = " + str(num - now) + " + " + str(now))
        break