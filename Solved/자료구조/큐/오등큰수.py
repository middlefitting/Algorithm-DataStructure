from collections import deque


def add_dict(d, x):
    try:
        d[x] += 1
    except:
        d[x] = 1


if __name__ == "__main__":
    N = int(input())
    nums = list(map(int, input().split()))
    compare = deque([])
    answer = [-1] * len(nums)
    d = dict()
    for i in range(N):
        x = nums[N - i - 1]
        add_dict(d, x)
    for i in range(N):
        x = nums[N - i - 1]
        while compare:
            y = compare.pop()
            if d[y] > d[x]:
                compare.append(y)
                answer[N - i - 1] = y
                break
        compare.append(x)
    for i in answer:
        print(i, end=" ")


