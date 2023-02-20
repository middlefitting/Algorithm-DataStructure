from collections import deque

if __name__ == '__main__':
    N, K = map(int, input().split())
    queue = deque(['?'] * N)
    alpha = dict()
    possible = True
    for _ in range(K):
        n, temp = map(str, input().split())
        for i in range(int(n)):
            queue.append(queue.popleft())
        re = queue.popleft()
        if re != '?' and re != temp:
            possible = False
            break
        try:
            alpha[temp] += 1
            if re != temp:
                possible = False
                break
            else:
                queue.appendleft(temp)
        except:
            alpha[temp] = 1
            queue.appendleft(temp)
    if possible:
        print(queue.popleft(), end="")
        while queue:
            print(queue.pop(), end="")
    else:
        print("!")

