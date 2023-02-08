# TimeComplex: O(N)
n,m = map(int, input().split())
data = list(map(int, input().split()))

count = 0
intervalSum = 0
end = 0

for start in range(n):
  while(intervalSum < m and end<n):
    intervalSum += data[end]
    end += 1
  if(intervalSum == m):
    count += 1
  intervalSum -= data[start]

print(count)