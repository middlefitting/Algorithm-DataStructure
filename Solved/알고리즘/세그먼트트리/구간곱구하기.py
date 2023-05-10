import sys
from collections import deque
sys.setrecursionlimit(10**6)


"""
리프 노드 사이즈를 반환
"""
def get_leaf_size() -> int:
    leaf_size = 2
    while leaf_size < N:
        # 리프 노드는 2의 N승의 형태로 나타야ㅑ 한다
        leaf_size *= 2
    return leaf_size


"""
리프 노드를 초기화
"""
def init_leaf():
    queue = deque([])
    for i in range(N):
        queue.append(int(sys.stdin.readline()))
    for i in range(leaf_size - N):
        queue.append(1)
    ind = leaf_size * 2
    while queue:
        ind -= 1
        arr[ind] = queue.pop()


"""
리프 노드를 제외한 초기값 세팅
"""
def construct():
    ind = leaf_size - 2
    while ind >= 1:
        arr[ind] = (arr[ind * 2] * arr[ind * 2 + 1]) % 1000000007
        ind -= 1


"""
세그먼트 트리 업데이트
"""
def update_logic(ind, change):
    ind += leaf_size - 1
    arr[ind] = change
    while ind > 1:
        ind //= 2
        arr[ind] = (arr[ind * 2] * arr[ind * 2 + 1]) % 1000000007


"""
세그먼트 트리 값을 반환
"""
def multify_logic(l: int, r: int, node_num: int, node_l: int, node_r: int) -> int:
    if r < node_l or l > node_r:
        return 1
    if l <= node_l and r >= node_r:
        return arr[node_num]
    mid = (node_l + node_r) // 2
    return multify_logic(l, r, node_num * 2, node_l, mid) * multify_logic(l, r, node_num * 2 + 1, mid + 1, node_r) % 1000000007


"""
세그먼트 트리 값을 출력
"""
def print_logic(start, end):
    result = multify_logic(start, end, 1, 1, leaf_size)
    print(result)


"""
기본 로직
"""
def update_and_print():
    for i in range(M + K):
        a, b, c = map(int, sys.stdin.readline().split())
        if a == 1:
            update_logic(b, c)
        elif a == 2:
            print_logic(b, c)


if __name__ == "__main__":
    N, M, K = map(int, sys.stdin.readline().split())
    leaf_size = get_leaf_size()
    arr = [1] * (leaf_size * 2)
    init_leaf()
    construct()
    update_and_print()

