class Game:
    def __init__(self, arr):
        self.__answer = []
        self.__flag = False
        self.__arr = arr

    def game_start(self, depth, loc):
        if self.__flag:
            return
        if depth > 50:
            return
        if loc == len(self.__arr):
            for i in self.__answer:
                if int(i) > len(self.__answer):
                    return
            self.__flag = True
            self.to_string_answer()
            return
        if self.__arr[loc] == "0":
            return
        if loc < len(self.__arr) and (self.__arr[loc] not in self.__answer) and (int(self.__arr[loc]) <= len(s)):
            self.__answer.append(self.__arr[loc])
            self.game_start(depth + 1, loc + 1)
            self.__answer.pop()
        if loc + 1 < len(self.__arr) and (self.__arr[loc:loc + 2] not in self.__answer) and (int(self.__arr[loc:loc + 2]) <= len(s)):
            self.__answer.append(self.__arr[loc:loc + 2])
            self.game_start(depth + 1, loc + 2)
            self.__answer.pop()

    def to_string_answer(self):
        for i in range(len(self.__answer)):
            if i != (len(self.__answer) - 1):
                print(self.__answer[i], end=" ")
            else:
                print(self.__answer[i])


if __name__ == "__main__":
    s = str(input())
    game = Game(s)
    game.game_start(0, 0)

