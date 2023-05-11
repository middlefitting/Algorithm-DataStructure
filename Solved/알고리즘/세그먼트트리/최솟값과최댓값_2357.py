import math
import sys
from collections import deque
from typing import Callable
sys.setrecursionlimit(10**6)


# 세그먼트 트리
class SegmentTree:
    def __init__(self, func: Callable[..., int], n: int, arr: deque):
        # 함수를 받아서 해당 함수로 로직을 처리
        self.__func : Callable[..., int] = func
        self.__leaf_cnt : int = 2
        self.__set_leaf_cnt(n)
        if func == max:
            self.__nodes: list = [1] * (self.__leaf_cnt * 2)
        else:
            self.__nodes: list = [math.inf] * (self.__leaf_cnt * 2)
        self.__set_nodes(n, arr)

    # 리프 노드의 개수 설정
    def __set_leaf_cnt(self, n: int):
        while self.__leaf_cnt < n:
            self.__leaf_cnt *= 2

    # 노드 초기화
    def __set_nodes(self, n: int, arr: deque):
        self.__set_leaf_nodes(n, arr)
        self.__set_except_leaf_node(n)

    # 리프 노드 초기화
    def __set_leaf_nodes(self, n: int, queue: deque):
        ind: int = self.__leaf_cnt * 2
        while len(queue) < self.__leaf_cnt:
            if self.__func == max:
                queue.append(1)
            else:
                queue.append(math.inf)
        while queue:
            ind -= 1
            self.__nodes[ind] = queue.pop()

    # 리프 노드를 제외하고 초기화
    def __set_except_leaf_node(self, n: int):
        ind: int = self.__leaf_cnt - 1
        while ind > 1:
            ind -= 1
            self.__nodes[ind] = self.__func(self.__nodes[ind * 2], self.__nodes[ind * 2 + 1])

    # 구간에 해당하는 값 반환
    def get_answer(self, start: int, end: int) -> float:
        return self.__segment_logic(start, end, 1, 1, self.__leaf_cnt)

    # 세그먼트 트리의 로직
    def __segment_logic(self, l: int, r: int, node_num: int, node_l: int, node_r: int) -> float:
        if r < node_l or l > node_r:
            if self.__func == max:
                return 1
            else:
                return math.inf
        if l <= node_l and r >= node_r:
            return self.__nodes[node_num]
        mid: int = (node_l + node_r) // 2
        return self.__func(self.__segment_logic(l, r, node_num * 2, node_l, mid), self.__segment_logic(l, r, node_num * 2 + 1, mid + 1, node_r))


if __name__ == "__main__":
    N: int
    M: int
    queue: deque = deque([])
    N, M = map(int, sys.stdin.readline().split())
    for i in range(N):
        queue.append(int(sys.stdin.readline()))
    min_tree: SegmentTree = SegmentTree(min, N, queue.copy())
    max_tree: SegmentTree = SegmentTree(max, N, queue)
    for i in range(M):
        a, b = map(int, sys.stdin.readline().split())
        print(min_tree.get_answer(a, b), max_tree.get_answer(a, b))
