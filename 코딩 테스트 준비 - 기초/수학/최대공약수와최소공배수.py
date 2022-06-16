A = int(input())
B = int(input())

p = 1
q = 1
i = 2
while (i <= A and i <= B) :
  if (A % i == 0 and B % i == 0) :
    p *= i
    A /= i
    B /= i
    i = 2
  else :
    i += 1

q = p * A * B
print(p)
print(q)