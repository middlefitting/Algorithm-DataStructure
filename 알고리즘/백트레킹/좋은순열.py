import sys

N = [0]
N[0] = int(input())
temp = [1]


def back_track(depth):
    i = 1
    while True:
        if i * 2 > depth:
            break
        if temp[-i:] == temp[-2 * i: -i]:
            return
        i += 1

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
