N = int(input())
youngsic = 0
minsic = 0
arr = list(map(int, input().split()))
for i in range(N):
    youngsic += (arr[i] // 30) * 10
    youngsic += 10
    minsic += (arr[i] // 60) * 15
    minsic += 15
if youngsic < minsic:
    print("Y", youngsic)
elif minsic < youngsic:
    print("M", minsic)
else:
    print("Y", "M", minsic)
