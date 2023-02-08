import sys

arr = list(map(int, input().split()))
copyArr = arr.copy()
copyArr.sort()

if copyArr.__eq__(arr):
    print("ascending")
    sys.exit()

copyArr.sort(reverse=True)
if copyArr.__eq__(arr):
    print("descending")
    sys.exit()

print("mixed")