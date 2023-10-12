import heapq

class Minecraft:
    def __init__(self, n, m, k, arr):
        self.N = n
        self.M = m
        self.K = k
        self.arr = arr
        self.minimum = 256
        self.maximum = 0
        for i in range(n):
            temp_min = min(arr[i])
            self.minimum = min(temp_min, self.minimum)
            temp_max = max(arr[i])
            self.maximum = max(temp_max, self.maximum)

    def print_result(self):
        answer = []
        for l in range(self.minimum, self.maximum + 1):
            inventory = self.K
            fill = 0
            remove = 0
            for i in range(self.N):
                for j in range(self.M):
                    if self.arr[i][j] < l:
                        fill += (l - self.arr[i][j])
                    else:
                        remove += (self.arr[i][j] - l)
            if inventory + remove < fill:
                continue
            time = fill * 1 + remove * 2
            heapq.heappush(answer, [time, -1 * l])
        result = heapq.heappop(answer)
        print(result[0], result[1] * -1)


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    minecraft = Minecraft(N, M, K, arr)
    minecraft.print_result()
