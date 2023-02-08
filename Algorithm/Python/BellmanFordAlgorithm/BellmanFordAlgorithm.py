# TimeComplex: O(VE)
import sys
input = sys.stdin.readline
INF = int(1e9)

def bellmanFord(start):
  dist[start] = 0
  for i in range(n):
    for j in range(m):
      cur = edges[j][0]
      nextNode = edges[j][1]
      cost = edges[j][2]
      if dist[cur] != INF and dist[nextNode] > dist[cur] + cost:
        dist[nextNode] = dist[cur] + cost
        if i==n-1:
          return True
  
  return False

n, m = map(int, input().split())
edges = []
dist = [INF] * (n+1)

for _ in range(m):
  a,b,c, = map(int, input().split())
  edges.append((a,b,c))

negativeCycle = bellmanFord(1)
if negativeCycle:
  print("-1")
else:
  for i in range(2,n+1):
    if dist[i] == INF:
      print("-1")
    else:
      print(dist[i])
