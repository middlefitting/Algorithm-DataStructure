while (True) :
  try :
    n = int(input())
    num = 0
    i = 0
    while (True) :
      num = num * 10 + 1
      i += 1
      if (num % n == 0) :
        print(i)
        break
  except :
    break
