class Node:
    def __init__(self, data, pre=None, next=None):
        self.data = data
        self.pre = pre
        self.next = next


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, node):
        if self.head == None:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            node.pre = self.tail
            self.tail = node

    def delete_node(self, node):
        if node is None:
            return
        if node.pre is not None:
            node.pre.next = node.next
        if node.next is not None:
            node.next.pre = node.pre
        if node == self.head:
            self.head = node.pre
            if self.head is None:
                self.head = node.next
        return node.pre

    def append_node(self, node, new):
        if node is not None:
            new.next = node.next
            if node.next is not None:
                node.next.pre = new
            node.next = new
            new.pre = node
        else:
            new.next = self.head
            self.head = new
            if new.next is not None:
                new.next.pre = new
        return new

    def print(self):
        temp = self.head
        while temp is not None:
            print(temp.data, end="")
            temp = temp.next


arr = list(str(input()))
curser = [None, None]
l = LinkedList()
for i in arr:
    node = Node(i)
    curser = [node, node.next]
    l.append(curser[0])
for i in range(int(input())):
    temp = list(map(str, input().split()))
    if temp[0] == "L":
        if curser[0] is not None:
            curser[1] = curser[0]
            curser[0] = curser[0].pre
    if temp[0] == "D":
        if curser[1] is not None:
            curser[0] = curser[1]
            curser[1] = curser[1].next
    if temp[0] == "B":
        curser[0] = l.delete_node(curser[0])
    if temp[0] == "P":
        curser[0] = l.append_node(curser[0], Node(temp[1]))
        curser[1] = curser[0].next
l.print()
print()
