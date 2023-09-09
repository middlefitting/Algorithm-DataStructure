# 효율적으로 짜른다
# 큰거 부터 채운다
    # 큰거 부터 채웠을때 효율적으로 짜르면 된다. 공간이나 접근이나
from collections import deque

flag = False
squares = deque([list(map(int, input().split()))])
s = squares[0][0] * squares[0][1] * squares[0][2]
print(squares[0][0] * squares[0][1] * squares[0][2])
answer = 0
arr = []
dic = dict()
for i in range(int(input())):
    arr.append(list(map(int, input().split())))
arr.sort(key=lambda z: z[0], reverse=True)
for x, c in arr:
    x = x
    c = c
    while squares:
        if c == 0:
            break
        if c < 0:
            print("error!!!!!!")
            exit()
        # print("start")
        temp = [2**x, 2**x, 2**x]
        # print(temp)
        t_c = 1
        square = squares.popleft()
        if min(square) < 2**x:
            squares.append(square)
            break
        while True:
            if (min(square) >= min(temp) * 2) and (t_c * 2 <= c):
                temp[temp.index(min(temp))] *= 2
                t_c *= 2
            else:
                break
        try:
            dic[2**x] += t_c
        except:
            dic[2**x] = t_c
        square.sort()
        temp.sort()
        for i in range(3):
            if square[i] > temp[i]:
                t_s = square.copy()
                square[i] = temp[i]
                t_s[i] -= temp[i]
                squares.append(t_s)
            elif square[i] < temp[i]:
                print("error!")
                exit(1)

        # print(t_c, c)
        # print(square)
        # print(temp)
        c -= t_c
        answer += t_c
        # print(answer)


        # te = 0
        # for a, b, k in squares:
        #     te += a * b * k
        # print(t_c)
        # print(2**x)
        # print(temp, square)
        # print(te)
        # print(s)
        # print(t_c * ((2**x)**3))
        # s -= t_c * ((2**x)**3)
        # print(s)
        # if (s != te):
        #     print("here!!!")
        #     exit(1)
        # print("=========")
if not squares:
    print("answer")
    print(answer)
    print()
else:
    print(-1)
ttt = 0
for key, value in dic.items():
    print(key, value)
    print(key ** 3 * value)
    ttt += key ** 3 * value
print(ttt)