N = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())
tm = A // C
if A % C != 0:
    tm += 1
te = B // D
if B % D != 0:
    te += 1
print(N - max(tm, te))
