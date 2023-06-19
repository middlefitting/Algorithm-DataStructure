D, H, M = map(int, input().split())
D -= 11
H -= 11
M -= 11
if M < 0:
    H -= 1
    M += 60
if H < 0:
    D -= 1
    H += 24
if D < 0 or H < 0:
    print(-1)
else:
    print(D * 60 * 24 + H * 60 + M)
