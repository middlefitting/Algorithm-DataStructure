import sys

N = int(sys.stdin.readline())
me = []
left = []
right = []

for i in range(N):
    A, B, C = map(str, sys.stdin.readline().split())
    me.append(A)
    left.append(B)
    right.append(C)


def preOrder(root):
    ind = me.index(root)
    print(me[ind], end="")
    if left[ind] != '.':
        preOrder(left[ind])
    if right[ind] != '.':
        preOrder(right[ind])


def inOrder(root):
    ind = me.index(root)
    if left[ind] != '.':
        inOrder(left[ind])
    print(me[ind], end="")
    if right[ind] != '.':
        inOrder(right[ind])


def postOrder(root):
    ind = me.index(root)
    if left[ind] != '.':
        postOrder(left[ind])
    if right[ind] != '.':
        postOrder(right[ind])
    print(me[ind], end="")


preOrder('A')
print()
inOrder('A')
print()
postOrder('A')
print()
