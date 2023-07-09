import math


def calculator():
    D, L = map(int, input().split())
    arr = list(map(float, input().split()))
    sarr = [[float(0)] * D for _ in range(D)]
    if D < L:
        print("Invalid Input!")
        exit(1)
    for i in range(D):
        for j in range(i, D):
            if i == j:
                sarr[i][j] = arr[i]
            else:
                sarr[i][j] = sarr[i][j - 1] + arr[j]
    answer = math.inf
    for i in range(D):
        for j in range(i + L - 1, D):
            answer = min(answer, sarr[i][j] / (j - i + 1))
    print(answer)


if __name__ =="__main__":
    for T in range(int(input())):
        calculator()