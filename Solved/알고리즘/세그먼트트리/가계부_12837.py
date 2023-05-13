import sys


class SegmentTree:
    def __init__(self, n):
        self.__leaf_cnt = self.__calc_leaf_cnt(n)
        self.__arr = [0] * (self.__leaf_cnt * 2 + 1)

    def __calc_leaf_cnt(self, n):
        result = 2
        while result < n:
            result *= 2
        return result

    def update(self, ind, value):
        temp = ind + self.__leaf_cnt - 1
        self.__arr[temp] += value
        while temp > 1:
            temp //= 2
            self.__arr[temp] = self.__arr[temp * 2] + self.__arr[temp * 2 + 1]

    def get_range(self, start, end):
        return self.__calc_money(start, end, 1, 1, self.__leaf_cnt)

    def __calc_money(self, l, r, node, node_l, node_r):
        if l > node_r or r < node_l:
            return 0
        if l <= node_l and r >= node_r:
            return self.__arr[node]
        mid = (node_l + node_r) // 2
        return self.__calc_money(l, r, node * 2, node_l, mid) + self.__calc_money(l, r, node * 2 + 1, mid + 1, node_r)


if __name__ == "__main__":
    N, Q = map(int, sys.stdin.readline().split())
    segment_tree = SegmentTree(N)
    for _ in range(Q):
        ind, p, q = map(int, sys.stdin.readline().split())
        if ind == 1:
            segment_tree.update(p, q)
        elif ind == 2:
            print(segment_tree.get_range(p, q))
