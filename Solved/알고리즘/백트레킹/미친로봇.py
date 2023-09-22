class CrazyRobot:
    def __init__(self):
        self.N, self.east, self.west, self.south, self.north = map(float, input().split())
        self.N = int(self.N)
        self.east /= 100
        self.west /= 100
        self.north /= 100
        self.south /= 100
        self.mv = [[1, 0, self.east], [-1, 0, self.west], [0, 1, self.south], [0, -1, self.north]]
        self.answer = 0.0

    def back_track(self, depth, x, y, visit, p):
        if depth == self.N:
            self.answer += p
            return
        for mx, my, mp in self.mv:
            tx, ty, tp = x + mx, y + my, p * mp
            if (tx, ty) not in visit:
                visit.add((tx, ty))
                self.back_track(depth + 1, tx, ty, visit, tp)
                visit.remove((tx, ty))


    def get_answer(self):
        return self.answer


if __name__ == "__main__":
    robot = CrazyRobot()
    visit = set()
    visit.add((0, 0))
    robot.back_track(0, 0, 0, visit, 1.0)
    print(robot.get_answer())


