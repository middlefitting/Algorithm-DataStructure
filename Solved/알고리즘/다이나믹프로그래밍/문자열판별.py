# softwarecontest
# 2
# software
# contest
import sys

sentence = str(input())
L = len(sentence)
dp = [0] * L
word = []
N = int(input())
for i in range(N):
    word.append(str(input()))


def dfs(temp):
    if temp == L:
        print(1)
        sys.exit()
    #해당 DP 자체를 방문했다면 추가 방문이 필요없다!!!!!!!!!
    if dp[temp]:
        return
    dp[temp] = 1
    for i in word:
        tLen = len(i)
        if temp + tLen <= L:
            if i == sentence[temp : temp + tLen]:
                dfs(temp + tLen)


dfs(0)
print(0)
