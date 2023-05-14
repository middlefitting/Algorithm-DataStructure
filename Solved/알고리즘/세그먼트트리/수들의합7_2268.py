import sys


class SegmentTree:
    def __init__(self, n: int):
        self.__set_leaf_cnt(n)
        self.__arr: list = [0] * (self.__leaf_cnt * 2 + 1)

    def __set_leaf_cnt(self, n: int):
        self.__leaf_cnt: int = 2
        while self.__leaf_cnt < n:
            self.__leaf_cnt *= 2

    def update(self, node: int, value: int):
        ind: int = node + self.__leaf_cnt - 1
        self.__arr[ind] = value
        while ind > 1:
            ind //= 2
            self.__arr[ind] = self.__arr[ind * 2] + self.__arr[ind * 2 + 1]

    def get_sum_range(self, start: int, end: int):
        return self.__calc_sum_range(start, end, 1, 1, self.__leaf_cnt)

    def __calc_sum_range(self, l: int, r: int, node: int, node_l: int, node_r: int) -> int:
        if l > node_r or r < node_l:
            return 0
        if l <= node_l and r >= node_r:
            return self.__arr[node]
        mid: int = (node_l + node_r) // 2
        return self.__calc_sum_range(l, r, node * 2, node_l, mid) + self.__calc_sum_range(l, r, node * 2 + 1, mid + 1, node_r)


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    segment_tree = SegmentTree(N)
    for _ in range(M):
        a, b, c = map(int, sys.stdin.readline().split())
        if a == 0:
            if b < c:
                print(segment_tree.get_sum_range(b, c))
            else:
                print(segment_tree.get_sum_range(c, b))
        elif a == 1:
            segment_tree.update(b, c)

