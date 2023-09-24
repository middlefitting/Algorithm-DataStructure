class ColorPaper:
    def __init__(self):
        self.__paper = [[0] * 100 for _ in range(100)]
        for _ in range(int(input())):
            l_len, b_len = map(int, input().split())
            self.__draw(l_len, b_len)

    def __draw(self, l_len, b_len):
        for i in range(100 - b_len - 10, 100 - b_len):
            for j in range(l_len, l_len + 10):
                self.__paper[i][j] = 1

    def calc(self):
        answer = 0
        for i in range(100):
            answer += sum(self.__paper[i])
        return answer


if __name__ == "__main__":
    color_paper = ColorPaper()
    print(color_paper.calc())
