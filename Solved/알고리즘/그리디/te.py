# 효율적으로 짜른다
# 큰거 부터 채운다
    # 큰거 부터 채웠을때 효율적으로 짜르면 된다. 공간이나 접근이나
from collections import deque
import heapq

flag = False
lst = list(map(int, input().split()))
squares = []
lst.sort()
lst[0] *= -1
heapq.heappush(squares, lst)

answer = 0

arr = []
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
        temp = [2**x, 2**x, 2**x]
        t_c = 1
        square = heapq.heappop(squares)
        square[0] *= -1
        if min(square) < 2**x:
            square[0] *= -1
            heapq.heappush(squares, square)
            break
        while True:
            if (min(square) >= min(temp) * 2) and (t_c * 2 <= c):
                temp[temp.index(min(temp))] *= 2
                t_c *= 2
            else:
                break
        square.sort()
        temp.sort()
        for i in range(3):
            if square[i] > temp[i]:
                t_s = square.copy()
                square[i] = temp[i]
                t_s[i] -= temp[i]
                t_s.sort()
                t_s[0] *= -1
                heapq.heappush(squares, t_s)
            elif square[i] < temp[i]:
                print("error!")
                exit(1)
        c -= t_c
        answer += t_c

if not squares:
    print(answer)
else:
    print(-1)
