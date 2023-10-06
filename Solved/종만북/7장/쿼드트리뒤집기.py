IDX = 0
ARR = ""


def quad_tree():
    global IDX
    temp = ARR[IDX]
    IDX += 1
    if temp != 'x':
        return temp
    lt, rt, lb, rb = quad_tree(), quad_tree(), quad_tree(), quad_tree()
    return "x" + lb + rb + lt + rt


if __name__ == "__main__":
    for _ in range(int(input())):
        ARR = str(input())
        IDX = 0
        print(quad_tree())
