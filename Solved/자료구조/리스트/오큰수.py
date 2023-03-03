from collections import deque

if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    stack = deque([])
    answer = []
    for i in range(N):
        ind = N - 1 - i
        flag = 0
        while stack:
            temp = stack.pop()
            if temp > arr[ind]:
                answer.append(temp)
                flag = 1
                stack.append(temp)
                break
        if not flag:
            answer.append("-1")
        stack.append(arr[ind])
    for i in range(len(answer)):
        if i != len(answer) -1 :
            print(answer[N - 1 - i], end=" ")
        else:
            print(answer[N - 1 - i])
