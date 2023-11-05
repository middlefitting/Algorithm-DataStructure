class WordDic:
    def __init__(self):
        self.words = set()
        self.dfs(0, "")
        self.arr = list(self.words)
        self.arr.sort()

    def dfs(self, depth, temp):
        if depth != 0:
            self.words.add(temp)
        if depth == 5:
            return
        for c in "AEIOU":
            self.dfs(depth + 1, temp + c)

    def get_ind(self, word):
        return self.arr.index(word) + 1


wordDic = WordDic()


def solution(word):
    global wordDic
    return wordDic.get_ind(word)


print(solution("AAAAE"))