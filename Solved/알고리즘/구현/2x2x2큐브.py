from collections import deque


class Cube:
    def __init__(self):
        self.positions = [
            deque([1, 3, 5, 7, 9, 11, 24, 22]),
            deque([2, 4, 6, 8, 10, 12, 23, 21]),
            deque([13, 14, 5, 6, 17, 18, 21, 22]),
            deque([15, 16, 7, 8, 19, 20, 23, 24]),
            deque([3, 4, 17, 19, 10, 9, 16, 14]),
            deque([1, 2, 18, 20, 12, 11, 15, 13])
        ]

        self.colors = deque(list(map(int, input().split())))
        self.colors.appendleft(0)
        self.flag = 0
        self.rotate()

    def rotate(self):
        for position in self.positions:
            for i in range(2):
                temp = position.copy()
                colors = self.colors.copy()
                self.logic(temp, position, colors, i)

    def logic(self, temp, position, colors, i):
        if i == 0:
            temp.append(temp.popleft())
            temp.append(temp.popleft())
        else:
            temp.appendleft(temp.pop())
            temp.appendleft(temp.pop())
        for j in range(8):
            colors[temp[j]] = self.colors[position[j]]
        for i in range(6):
            if not (colors[i * 4 + 1] == colors[i * 4 + 2] == colors[i * 4 + 3] == colors[i * 4 + 4]):
                return
        self.flag = 1

    def getAnswer(self):
        return self.flag


if __name__ == "__main__":
    cube = Cube()
    print(cube.getAnswer())
