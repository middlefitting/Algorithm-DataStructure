import sys
from collections import deque

def push_front() :
  dec.appendleft(temp[1])

def push_back() :
  dec.append(temp[1])

def pop_front() :
  if (len(dec) == 0) :
    print(-1)
    return
  print(dec[0])
  dec.popleft()

def pop_back() :
  if (len(dec) == 0) :
    print(-1)
    return
  print(dec[-1])
  dec.pop()

def size() :
  print(len(dec))

def empty() :
  if (len(dec) == 0) :
    print(1)
  else :
    print(0)

def front() :
  if (len(dec) == 0) :
    print(-1)
    return
  print(dec[0])

def back() :
  if (len(dec) == 0) :
    print(-1)
    return
  print(dec[-1])

N = int(input())
dec = deque()
for i in range(N) :
  temp = list(map(str, sys.stdin.readline().split()))
  getattr(sys.modules[__name__], temp[0])()
