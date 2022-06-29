N = int(input())
if (N == 1) :
  answer = 9
else :
  answer = (9 * (2 ** (N - 1)))- 1) % 1000000000
print(answer)