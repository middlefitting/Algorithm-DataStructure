temp = [0]
dir = ["N", "E", "S", "W"]
mv = [0, 1, 2, -1]


def turn(x):
    temp[0] += mv[x]
    if temp[0] > 3:
        temp[0] -= 4
    if temp[0] < 0:
        temp[0] += 4


if __name__ == "__main__":
    for i in range(10):
        turn(int(input()))
    print(dir[temp[0]])