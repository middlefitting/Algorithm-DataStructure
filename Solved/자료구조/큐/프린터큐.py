from collections import deque

if __name__ == "__main__":
    for _ in range(int(input())):
        N, M = map(int, input().split())
        arr = list(map(int, input().split()))
        arr_cp = arr.copy()
        find = arr[M]
        arr_cp[M] = -1
        answer = 0
        queue = deque(arr_cp)
        while queue:
            temp = queue.popleft()
            if temp == -1 and find == max(arr):
                answer += 1
                break
            elif temp == max(arr):
                answer += 1
                arr.pop(arr.index(temp))
            else:
                queue.append(temp)
        print(answer)
