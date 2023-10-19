def solution(sizes):
    temp = [sizes[0][0], sizes[0][1]]
    for i in range(len(sizes)):
        x = sizes[i][0]
        y = sizes[i][1]
        a = [max(temp[0], x), max((temp[1], y))]
        b = [max(temp[0], y), max((temp[1], x))]
        if a[0] * a[1] < b[0] * b[1]:
            temp = a
        else:
            temp = b
    answer = temp[0] * temp[1]
    return answer


print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))
