A = int(input())
B = int(input())
C = int(input())
s = set()
s.add(A)
s.add(B)
s.add(C)
if A == 60 and B == 60 and C == 60:
    print("Equilateral")
elif A + B + C == 180 and len(s) == 2:
    print("Isosceles")
elif A + B + C == 180:
    print("Scalene")
else:
    print("Error")