A, B = map(int, input().split())
C = int(input())
if C * 2 <= A + B:
    print((A + B) - C * 2)
else:
    print(A + B)
