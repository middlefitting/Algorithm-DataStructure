class Runway:
    def __init__(self, n, l):
        self.N = n
        self.L = l

    def possible(self, arr):
        v = [False] * self.N
        for i in range(1, self.N):
            if abs(arr[i] - arr[i - 1]) > 1:
                return False
            elif arr[i] == arr[i - 1]:
                continue
            elif arr[i] < arr[i - 1]:
                if i + self.L - 1 >= self.N:
                    return False
                for j in range(i, i + self.L):
                    if arr[j] != arr[i]:
                        return False
                    if v[j]:
                        return False
                    v[j] = True
            else:
                if i < self.L:
                    return False
                for j in range(i - self.L, i):
                    if arr[j] != arr[i -1]:
                        return False
                    if v[j]:
                        return False
                    v[j] = True
        return True


if __name__ == "__main__":
    answer = 0
    N, L = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    runway = Runway(N, L)
    for i in range(N):
        temp = []
        for j in range(N):
            temp.append(arr[j][i])
        if runway.possible(temp):
            answer += 1
        if runway.possible(arr[i]):
            answer += 1
    print(answer)