import sys


def prime():
    d = dict()
    result = []
    for i in range(2, 1000001):
        if i % 2 != 1:
            d[i] = False
        else:
            d[i] = True
    for temp in range(2, int(1000001 ** 0.5) + 1):
        if not d[temp]:
            continue
        ind = 2
        while temp * ind <= 1000000:
            ind += 1
            d[temp * ind] = False
    for i in range(2, 1000001):
        if d[i]:
            result.append(i)
    return [result, d]


if __name__ == "__main__":
    sosu, d = prime()
    while True:
        N = int(sys.stdin.readline())
        flag = False
        if N == 0:
            break
        for s in sosu:
            if s >= (N // 2) + 1:
                break
            if d[N - s]:
                print(f'{N} = {s} + {N - s}')
                flag = True
                break
        if not flag:
            print("Goldbach's conjecture is wrong.")
