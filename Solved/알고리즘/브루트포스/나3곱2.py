import sys

sin = sys.stdin.readline

d = dict()


def dfs(answers, depth, n):
    if depth == n:
        print(" ".join(str(num) for num in answers))
        exit(0)
    if (answers[-1] * 2 in d) and d[answers[-1] * 2] > 0:
        d[answers[-1] * 2] -= 1
        answers.append(answers[-1] * 2)
        dfs(answers, depth + 1, n)
        answers.pop()
        d[answers[-1] * 2] += 1
    if (answers[-1] // 3 in d) and (answers[-1] % 3 == 0) and d[answers[-1] // 3] > 0:
        d[answers[-1] // 3] -= 1
        answers.append(answers[-1] // 3)
        dfs(answers, depth + 1, n)
        answers.pop()
        d[answers[-1] // 3] += 1


if __name__ == "__main__":
    N = int(sin())
    arr = list(map(int, sin().split()))
    for i in arr:
        d[i] = 1
    for i in arr:
        dfs([i], 0, N - 1)