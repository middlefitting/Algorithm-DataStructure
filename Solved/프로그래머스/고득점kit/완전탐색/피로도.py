class Search:
    def __init__(self, k, dungeons):
        self.life = k
        self.dungeons = dungeons
        self.answer = 0
        self.size = len(dungeons)
        self.v = [False] * self.size

    def dfs(self, depth, life):
        self.answer = max(depth, self.answer)
        if depth > self.size:
            return
        for i in range(self.size):
            if self.v[i]:
                continue
            if self.dungeons[i][0] > life:
                continue
            else:
                self.v[i] = True
                self.dfs(depth + 1, life - self.dungeons[i][1])
                self.v[i] = False

    def get_answer(self):
        self.dfs(0, self.life)
        return self.answer


def solution(k, dungeons):
    search = Search(k, dungeons)
    return search.get_answer()

if __name__=="__main__":
    print(
        solution(80, [[80,20], [80,20]])
    )