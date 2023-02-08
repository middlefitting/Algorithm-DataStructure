# TimeComplex: O(NlogN)
# Idea: Complete Binary Tree
# Heapify: O(logN) to maintain heap

import sys
import heapq
input = sys.stdin.readline

def heapSortAsc(iterable):
  h = []
  result = []
  for value in iterable:
    heapq.heappush(h, value)
  for i in range(len(h)):
    result.append(heapq.heappop(h))
  return result

def heapSortDsc(iterable):
  h = []
  result = []
  for value in iterable:
    heapq.heappush(-h, value)
  for i in range(len(h)):
    result.append(-heapq.heappop(h))
  return result

n = int(input())
arr = []
for i in range(n):
  arr.append(int(input()))

asc = heapSortAsc(arr)
dsc = heapSortDsc(arr)
print(asc)
print(dsc)