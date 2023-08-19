A = 300
B = 60
C = 10

N = int(input())

a = N // A
N %= A
b = N // B
N %= B
c = N // C
N %= C
if N != 0:
    print(-1)
else:
    print(a, b, c)
