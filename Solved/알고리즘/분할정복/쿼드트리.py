N = int(input())
arr = []
for i in range(N):
    arr.append([])
    temp = list(str(input()))
    for j in range(N):
        arr[i].append(int(temp[j]))


def div_logic(tx, ty, length):
    next_length = length // 2
    print("(", end="")
    div_and_conquer(tx, ty, next_length)
    div_and_conquer(tx, ty + next_length, next_length)
    div_and_conquer(tx + next_length, ty, next_length)
    div_and_conquer(tx + next_length, ty + next_length, next_length)
    print(")", end="")


def div_and_conquer(tx, ty, length):
    s = 0
    for i in range(tx, tx + length):
        for j in range(ty, ty + length):
            s += arr[i][j]
    if s == 0:
        print(0, end="")
    elif s == length ** 2:
        print(1, end="")
    else:
        div_logic(tx, ty, length)


if __name__ == '__main__':
    div_and_conquer(0, 0, N)
