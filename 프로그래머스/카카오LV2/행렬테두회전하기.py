import math

min_value = [math.inf]
arr = []
mv = [[0, 1], [1, 0], [0, -1], [-1, 0]]


def move(a, b, c, d):
    i = a
    j = b
    temp = arr[i][j]
    for x, y in mv:
        while True:
            next_i = i + x
            next_j = j + y
            if (not a <= next_i <= c) or (not b <= next_j <= d):
                break
            min_value[0] = min(min_value[0], temp)

            next = arr[next_i][next_j]
            arr[next_i][next_j] = temp

            temp = next
            i = next_i
            j = next_j


def solution(rows, columns, queries):
    answer = []
    ind = 0
    for i in range(rows):
        arr.append([])
        for j in range(columns):
            ind += 1
            arr[i].append(ind)

    for a, b, c, d in queries:
        min_value[0] = math.inf
        move(a - 1, b - 1, c - 1, d - 1)
        answer.append(min_value[0])

    return answer

print(solution(6, 6, [[1,1,1,1]]))
print(arr)
