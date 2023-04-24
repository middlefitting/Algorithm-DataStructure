def left_right():
    result = 0
    for i in range(N):
        result += max(arr[i])
    return result * 2


def top_bottom():
    result = 0
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0:
                result += 1

    for i in range(N):
        for j in range(M):
            x = arr[i][j]
            l = x
            r = x
            ind = j
            while ind >= 0:
                if arr[i][ind] > x:
                    l = arr[i][ind]
                    break
                ind -= 1
            ind = j + 1
            while ind < M:
                if arr[i][ind] > x:
                    r = arr[i][ind]
                    break
                if arr[i][ind] == x:
                    break
                ind += 1
            f = min(l, r)
            f -= x
            result += f
    return result * 2


def front_back():
    result = 0
    for j in range(M):
        temp = 0
        for i in range(N):
            temp = max(temp, arr[i][j])
        result += temp

    for j in range(M):
        for i in range(N):
            x = arr[i][j]
            t = x
            b = x
            ind = i - 1
            while ind >= 0:
                if arr[ind][j] > x:
                    t = arr[ind][j]
                    break
                ind -= 1
            ind = i + 1
            while ind < N:
                if arr[ind][j] > x:
                    b = arr[ind][j]
                    break
                if arr[ind][j] == x:
                    break
                ind += 1
            f = min(t, b)
            f -= x
            result += f
    return result * 2


if __name__ == "__main__":
    N, M = map(int, input().split())
    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split())))
    answer = 0
    answer += left_right()
    answer += top_bottom()
    answer += front_back()
    print(answer)