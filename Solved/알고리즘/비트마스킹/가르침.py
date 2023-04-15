class BackTrack:
    def __init__(self, m):
        self.__max_depth = m - 5
        self.__answer = 0
        self.__alpha = dict()
        self.__mask = 0
        for i in range(26):
            self.__alpha[chr(ord('a') + i)] = i
        for a in "antic":
            self.__mask = self.__mask | 1 << self.__alpha[a]
        self.__target = self.__mask
        self.__arr = []

    def init_target(self, arr):
        for s in arr:
            mask = 0
            for c in s:
                mask = mask | 1 << self.__alpha[c]
                self.__target = self.__target | 1 << self.__alpha[c]
            self.__arr.append(mask)

    def back_tracking(self, depth, loc, mask):
        if depth == self.__max_depth or mask == self.__target:
            self.renew_answer(mask)
            return

        for i in range(loc, 26):
            if self.__target & 1 << i:
                self.back_tracking(depth + 1, i + 1, mask | 1 << i)

    def renew_answer(self, mask):
        result = 0
        for t_m in self.__arr:
            if mask & t_m == t_m:
                result += 1
        if result > self.__answer:
            self.__answer = result

    def get_mask(self):
        return self.__mask

    def get_answer(self):
        return self.__answer


if __name__ == "__main__":
    N, M = map(int, input().split())
    backTrack = BackTrack(M)
    arr = []
    for i in range(N):
        arr.append(str(input()))
    if M < 5:
        print(0)
        exit(0)
    backTrack.init_target(arr)
    backTrack.back_tracking(0, 0, backTrack.get_mask())
    print(backTrack.get_answer())

