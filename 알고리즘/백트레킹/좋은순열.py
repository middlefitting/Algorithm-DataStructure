import sys

N = [0]
N[0] = int(input())
temp = [1]


def back_track(depth):
    if depth != 1:
        if temp[-1] == temp[-2]:
            return

    if depth % 2 == 0:
        if temp[-1] == temp[(depth // 2) - 1]:
            return

    if depth == N[0]:
        for i in temp:
            print(i, end="")
        print("")
        sys.exit()

    for i in range(1, 4):
        temp.append(i)
        back_track(depth + 1)
        temp.pop()


back_track(1)
