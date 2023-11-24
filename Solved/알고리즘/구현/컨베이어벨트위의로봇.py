from collections import deque


class Belt:
    def __init__(self, arr, N, K):
        self.N = N
        self.K = K
        self.zero_cnt = 0
        self.up_belt = deque([])
        self.down_belt = deque([])
        for i in range(2 * N):
            if i < N:
                self.up_belt.append([False, arr[i]])
            else:
                self.down_belt.appendleft(arr[i])

    def get_answer(self):
        answer = 0
        while self.zero_cnt < self.K:
            answer += 1
            self.up_belt.appendleft([False, self.down_belt.popleft()])
            self.down_belt.append(self.up_belt.pop()[1])
            self.up_belt[self.N - 1][0] = False
            for i in range(1, self.N):
                x = self.N - 1 - i
                if not self.up_belt[x][0]:
                    continue
                if self.up_belt[x + 1][1] and (not self.up_belt[x + 1][0]):
                    self.up_belt[x][0] = False
                    self.up_belt[x + 1][0] = True
                    self.up_belt[x + 1][1] -= 1
                    if not self.up_belt[x + 1][1]:
                        self.zero_cnt += 1
            if self.up_belt[0][1]:
                self.up_belt[0][1] -= 1
                self.up_belt[0][0] = True
                if not self.up_belt[0][1]:
                    self.zero_cnt += 1
        return answer


if __name__ == "__main__":
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    belt = Belt(arr, N, K)
    print(belt.get_answer())
