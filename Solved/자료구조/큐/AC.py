from collections import deque

if __name__ == "__main__":
    for _ in range(int(input())):
        commend = list(str(input()))
        N = int(input())
        arr_str = str(input())
        arr_str = arr_str.replace("[", "")
        arr_str = arr_str.replace("]", "")
        if N != 0:
            queue = deque(list(map(int, arr_str.split(","))))
        else:
            queue = deque([])

        flag = True
        possible = 1
        answer = []
        for c in commend:
            if c == 'R':
                flag = not flag
            elif c == 'D':
                try:
                    if flag:
                        queue.popleft()
                    else:
                        queue.pop()
                except:
                    possible = False
                    break
        if flag:
            while queue:
                answer.append(queue.popleft())
        else:
            while queue:
                answer.append(queue.pop())
        if possible:
            print("[", end="")
            for i in range(len(answer)):
                if i != len(answer) - 1:
                    print(str(answer[i]) + ",", end="")
                else:
                    print(answer[i], end="")
            print("]")
        else:
            print("error")
