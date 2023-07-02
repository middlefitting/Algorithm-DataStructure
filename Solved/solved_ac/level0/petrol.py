N = int(input())
M = int(input())
need = N - M
if need <= 60:
    print(1500 * N)
else:
    print(1500 * N + (need - 60) * 1500)
