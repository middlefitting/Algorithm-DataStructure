import math
import sys

sin = sys.stdin.readline
N = int(sin())
arr = list(sin().rstrip())
answer = math.inf * -1


def dfs(idx, value):
    global N
    global answer
    if N == idx:
        answer = max(answer, int(value))
        return
    if idx + 4 <= N:
        dfs(idx + 4, str(eval(''.join([value, arr[idx]] + [str(eval(''.join(arr[idx + 1: idx + 4])))]))))
    if idx + 2 <= N:
        dfs(idx + 2, str(eval(''.join([value] + arr[idx:idx + 2]))))


if __name__ == "__main__":
    dfs(1, arr[0])
    print(answer)
