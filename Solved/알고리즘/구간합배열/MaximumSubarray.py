import math

if __name__ == "__main__":
    for __ in range(int(input())):
        N = int(input())
        arr = list(map(int, input().split()))
        s_arr = [0] * N
        answer = math.inf * -1
        for i in range(N):
            if i != 0:
                s_arr[i] = s_arr[i - 1]
            s_arr[i] += arr[i]
        for i in range(N):
            for j in range(i + 1):
                temp = s_arr[i]
                if j != 0:ㄴ
                    temp -= s_arr[j - 1]
                answer = max(answer, temp)
        print(answer)
