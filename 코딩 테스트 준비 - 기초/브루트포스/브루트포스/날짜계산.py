a, b, c = map(int, input().split())

n = b
while (1) :
  if ((n - a) % 15 == 0 and (n -c) % 19 == 0) :
    print(n)
    break
  n += 28