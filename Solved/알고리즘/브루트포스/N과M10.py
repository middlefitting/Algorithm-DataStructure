
def ft_print(temp):
    for i in temp:
        print(i, end=" ")
    print()


def back_track(depth, temp, mask):
    if depth == M:
        ft_print(temp)
        return
    for i in range(len(arr)):
        if mask & 1 << i:
            continue
        if i > 0 and arr[i] == arr[i - 1] and (not mask & 1 << (i - 1)):
            continue
        if arr[i] < temp[-1]:
            continue
        temp.append(arr[i])
        back_track(depth + 1, temp, mask | 1 << i)
        temp.pop()


if __name__ == "__main__":
    N, M = map(int, input().split())
    d = dict()
    arr = list(map(int, input().split()))
    arr.sort()
    answer = []
    for i in range(N):
        if i > 0 and arr[i] == arr[i - 1]:
            continue
        answer.append(arr[i])
        back_track(1, answer, 0 | 1 << i)
        answer.pop()
