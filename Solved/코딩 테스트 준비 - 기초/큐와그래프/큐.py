import sys

def push() :
  queue.append(temp[1])

def pop() :
  if (len(queue) == 0) :
    print(-1)
    return
  print(queue[0])
  queue.pop(0)

def size() :
  print(len(queue))

def empty() :
  if (len(queue) == 0) :
    print(1)
  else :
    print(0)

def front() :
  if (len(queue) == 0) :
    print(-1)
    return
  print(queue[0])

def back() :
  if (len(queue) == 0) :
    print(-1)
    return
  print(queue[-1])

N = int(input())
queue = []
for i in range(N) :
  temp = list(map(str, sys.stdin.readline().split()))
  getattr(sys.modules[__name__], temp[0])()