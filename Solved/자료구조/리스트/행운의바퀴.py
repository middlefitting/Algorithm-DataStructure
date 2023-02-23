from collections import deque


def is_possible_visit(re, temp):
    if re != '?' and re != temp:
        possible[0] = False
        return False
    return True


def is_possible_renewal(re, temp):
    try:
        alpha[temp] += 1
        if re != temp:
            possible[0] = False
            return False
        else:
            queue.appendleft(temp)
    except:
        alpha[temp] = 1
        queue.appendleft(temp)
    return True


def print_logic():
    if possible[0]:
        print(queue.popleft(), end="")
        while queue:
            print(queue.pop(), end="")
    else:
        print("!")


if __name__ == '__main__':
    N, K = map(int, input().split())
    queue = deque(['?'] * N)
    alpha = dict()
    possible = [True]
    for _ in range(K):
        n, temp = map(str, input().split())
        for i in range(int(n)):
            queue.append(queue.popleft())
        re = queue.popleft()
        if not is_possible_visit(re, temp):
            break
        if not is_possible_renewal(re, temp):
            break
    print_logic()
