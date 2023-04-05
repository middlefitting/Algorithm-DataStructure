import sys

if __name__ == "__main__":
    s = str(sys.stdin.readline())
    arr = [[0] * len(s) for _ in range(26)]
    for i in range(len(s)):
        for j in range(26):
            if i != 0:
                arr[j][i] = arr[j][i - 1]
            if ord(s[i]) - ord('a') == j:
                arr[j][i] += 1

    for i in range(int(sys.stdin.readline())):
        a, s, e = map(str, sys.stdin.readline().split())
        a = ord(a) - ord('a')
        s = int(s)
        e = int(e)
        temp = arr[a][e]
        if s != 0:
            temp -= arr[a][s - 1]
        print(temp)

