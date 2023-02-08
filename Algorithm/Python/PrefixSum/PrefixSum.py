# TimeComplex: O(N+M)
# Idea: Prefix Sum
n = int(input())
data = list(map(int, input().split()))

sumValue = 0
prefixSum = [0]
for i in data:
  sumValue += i
  prefixSum.append(sumValue)

testCase = int(input())
for i in range(testCase):
  left, right = map(int, input().split())
  print(prefixSum[right] - prefixSum[left-1])