A, B, C, X, Y = map(int, input().split())
answer = 0
if C * 2 <= A + B:
    mix = min(X, Y)
    X -= mix
    Y -= mix
    answer += mix * 2 * C

if C * 2 <= A:
    answer += X * C * 2
else:
    answer += A * X

if C * 2 <= B:
    answer += Y * C * 2
else:
    answer += B * Y

print(answer)
