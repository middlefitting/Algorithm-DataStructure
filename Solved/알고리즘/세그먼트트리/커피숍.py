import sys


class SegmentTree:
    def __init__(self, n: int):
        self.__set_leaf_cnt(n)
        self.__set_nodes(n)

    def __set_leaf_cnt(self, n: int):
        self.__leaf_cnt = 2
        while self.__leaf_cnt < n:
            self.__leaf_cnt *= 2

    def __set_nodes(self, n: int):
        self.__arr: list = [0] * (self.__leaf_cnt * 2 + 1)
        self.__set_leaf_nodes(n)
        self.__set_parent_nodes()

    def __set_leaf_nodes(self, n: int):
        leafs: list = list(map(int, sys.stdin.readline().split()))
        for i in range(n):
            self.__arr[self.__leaf_cnt + i] = leafs[i]

    def __set_parent_nodes(self):
        ind: int = self.__leaf_cnt - 1
        while ind >= 1:
            self.__arr[ind] = self.__arr[ind * 2] + self.__arr[ind * 2 + 1]
            ind -= 1

    def update(self, node: int, value: int):
        ind: int = node + self.__leaf_cnt - 1
        self.__arr[ind] = value
        while ind > 1:
            ind //= 2
            self.__arr[ind] = self.__arr[ind * 2] + self.__arr[ind * 2 + 1]

    def get_range(self, start, end):
        return self.__sum_range(start, end, 1, 1, self.__leaf_cnt)

    def __sum_range(self, l: int, r: int, node: int, node_l: int, node_r: int):
        if l > node_r or r < node_l:
            return 0
        if l <= node_l and r >= node_r:
            return self.__arr[node]
        mid: int = (node_l + node_r) // 2
        return self.__sum_range(l, r, node * 2, node_l, mid) + self.__sum_range(l, r, node * 2 + 1, mid + 1, node_r)


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    segment_tree = SegmentTree(N)
    for i in range(M):
        a, b, c, d = map(int, sys.stdin.readline().split())
        if a <= b:
            print(segment_tree.get_range(a, b))
        else:
            print(segment_tree.get_range(b, a))
        segment_tree.update(c, d)