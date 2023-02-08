N, S = map(int, input().split())
arrIn = list(map(int, input().split()))
arr = []
for i in range(N):
    arr.append(arrIn[i])
arr.sort()
left = []
right = []
tempLeft = []
tempRight = []
leftSum = []
rightSum = []
left = arr[:len(arr)//2]
right = arr[len(arr)//2:]


def leftDfs(temp, depth):
    tempLeft.append(temp)
    for i in range(depth, len(left)):
        leftDfs(temp + left[i], i + 1)


def rightDfs(temp, depth):
    tempRight.append(temp)
    for i in range(depth, len(right)):
        rightDfs(temp + right[i], i + 1)


leftDfs(0, 0)
rightDfs(0, 0)
tempLeft.sort()
tempRight.sort()
leftSum.append([tempLeft[0], 1])
rightSum.append([tempRight[0], 1])
for i in range(1, len(tempLeft)):
    if leftSum[-1][0] == tempLeft[i]:
        leftSum[-1][1] += 1
    else:
        leftSum.append([tempLeft[i], 1])

for i in range(1, len(tempRight)):
    if rightSum[-1][0] == tempRight[i]:
        rightSum[-1][1] += 1
    else:
        rightSum.append([tempRight[i], 1])

l = 0
r = len(rightSum) - 1
answer = 0
while True:
    if leftSum[l][0] + rightSum[r][0] == S:
        answer += leftSum[l][1] * rightSum[r][1]
    if (l == (len(leftSum) - 1)) and r == 0:
        break
    if l == (len(leftSum) - 1):
        r -= 1
    elif r == 0:
        l += 1
    elif leftSum[l][0] + rightSum[r][0] < S:
        l += 1
    else:
        r -= 1
    # if l == (len(leftSum) - 1):
    #     r -= 1
    # elif r == 0:
    #     l += 1
    # elif abs(leftSum[l][0]) >= abs(rightSum[r][0]) and leftSum[l][0] <= 0:
    #     l += 1
    # elif abs(leftSum[l][0]) >= abs(rightSum[r][0]) and leftSum[l][0] > 0:
    #     r -= 1
    # elif abs(leftSum[l][0]) < abs(rightSum[r][0]) and leftSum[l][0] <= 0:
    #     r -= 1
    # elif abs(leftSum[l][0]) < abs(rightSum[r][0]) and leftSum[l][0] > 0:
    #     l += 1
    # else:
    #     print("err")

if S == 0:
    answer -= 1
print(answer)
