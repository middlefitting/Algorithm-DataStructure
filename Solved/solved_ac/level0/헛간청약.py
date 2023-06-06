N, W, H, L = map(int, input().split())
H //= L
W //= L
print(min(H * W, N))
