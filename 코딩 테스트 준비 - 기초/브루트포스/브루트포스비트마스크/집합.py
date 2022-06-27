import sys

def add(x) :
  if((x in S) == False) :
    S.add(x)

def remove(x) :
  if((x in S) == True) :
    S.discard(x)

def check(x) :
  if((x in S) == True) :
    print(1)
  else :
    print(0)

def toggle(x) :
  if((x in S) == True) :
    S.discard(x)
  else :
    S.add(x)

S = set()
N = int(input())
for i in range(N) :
  temp = sys.stdin.readline().strip().split()
  if(len(temp) == 1) :
    if (temp[0] == "all") :
      S = set([i for i in range(1, 21)])
    else :
      S = set()
  elif(len(temp) == 2) :
    globals()[temp[0]](int(temp[1]))