class Node:
  def __init__(self, data, leftNode, rightNode):
    self.data = data
    self.leftNode = leftNode
    self.rightNode = rightNode

def preOrder(node):
  print(node.data, end=' ')
  if node.leftNode != None:
    preOrder(tree[node.leftNode])
  if node.rightNode != None:
    preOrder(tree[node.rightNode])

def inOrder(node):
  if node.leftNode != None:
    inOrder(tree[node.leftNode])
  print(node.data, end=' ')
  if node.rightNode != None:
    inOrder(tree[node.rightNode])

def postOrder(node):
  if node.leftNode != None:
    postOrder(tree[node.leftNode])
  if node.rightNode != None:
    postOrder(tree[node.rightNode])
  print(node.data, end=' ')

n = int(input())
tree={}

for i in range(n):
  data, leftNode, rightNode = input().split()
  if leftNode =="None":
    leftNode = None
  if rightNode =="None":
    rightNode = None
  tree[data] = Node(data, leftNode, rightNode)

preOrder(tree['A'])
print()
inOrder(tree['A'])
print()
postOrder(tree['A'])
print()