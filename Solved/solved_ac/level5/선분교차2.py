x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

d1 = [x1, y1]
d2 = [x2, y2]
d3 = [x3, y3]
d4 = [x4, y4]


def ccw(d1, d2, d3):
    s1 = d1[0] * d2[1] + d2[0] * d3[1] + d3[0] * d1[1]
    s2 = d1[1] * d2[0] + d2[1] * d3[0] + d3[1] * d1[0]
    return s1 - s2

def isCross(d1, d2, d3, d4):
    ccw1 = ccw(d1, d2, d3)
    ccw2 = ccw(d1, d2, d4)
    ccw3 = ccw(d3, d4, d1)
    ccw4 = ccw(d3, d4, d2)
    if (d1 ==  d3) or (d1 ==  d4) or (d2 ==  d3) or (d2 ==  d4):
        return 1

    if (ccw1 * ccw2 < 0) and (ccw3 * ccw4 < 0):
        return 1
    if (ccw1 * ccw2 == 0) and (ccw3 * ccw4 < 0):
        return 1
    if (ccw1 * ccw2 < 0) and (ccw3 * ccw4 == 0):
        return 1
    if (ccw1 * ccw2 == 0) and (ccw3 * ccw4 == 0):
        if (min(d1[0], d2[0]) <= d3[0]<= max(d1[0], d2[0])) and (min(d1[1], d2[1]) <= d3[1]<= max(d1[1], d2[1])):
            return 1
        if (min(d1[0], d2[0]) <= d4[0]<= max(d1[0], d2[0])) and (min(d1[1], d2[1]) <= d4[1]<= max(d1[1], d2[1])):
            return 1
        if (min(d3[0], d4[0]) <= d1[0]<= max(d3[0], d4[0])) and (min(d3[1], d4[1]) <= d1[1]<= max(d3[1], d4[1])):
            return 1
        if (min(d3[0], d4[0]) <= d2[0]<= max(d3[0], d4[0])) and (min(d3[1], d4[1]) <= d2[1]<= max(d3[1], d4[1])):
            return 1
    return 0


print(isCross(d1, d2, d3, d4))
