N = int(input())
arr = list(map(int, input().split()))
if arr.count(0) >= ((N + 1) // 2):
    print("INVALID")
    exit(0)
if sum(arr) > 0:
    print("APPROVED")
else:
    print("REJECTED")