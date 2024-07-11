class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
    
class DoublyLinkedList:
    def __init__(self):
        self.END = Node(-1)               # dummy 값을 넣고 시작
        self.head = self.END
        self.tail = self.END
    
    def push_front(self, new_data):       # 첫번째 위치에 삽입
        new_node = Node(new_data)         
        new_node.next = self.head

        self.head.prev = new_node
        self.head = new_node
        new_node.prev = None

    def push_back(self, new_data):
        if self.begin() == self.end():    # 만약, 리스트가 비어있다면? 
            self.push_front(new_data)     # dummy를 가장 마지막 원소로 넣어야함 = push_front
        
        else:
            new_node = Node(new_data)
            new_node.prev = self.tail.prev
            self.tail.prev.next = new_node
            new_node.next = self.tail
            self.tail.prev = new_node

    def erase(self, node):
        next_node = node.next

        if node == self.begin():           # 삭제할 node가 head일 경우
            temp = self.head
            temp.next.prev =None
            self.head = temp.next
            temp.next = None
        
        else:                              # 삭제할 node가 head가 아닐 경우
            node.prev.next = node.next
            node.next.prev = node.prev
            node.prev = None
            node.next = None

        return next_node

    
    def insert(self, node, new_data):      # node에 new_data를 insert
        if node == self.end():             # node가 tail일 경우
            self.push_back(new_data)       
        
        elif node == self.begin():         # node가 head일 경우
            self.push_front(new_data)      
        
        else:
            new_node = Node(new_data)
            new_node.prev = node.prev
            new_node.next = node
            node.prev.next = new_node
            node.prev = new_node
    
    def begin(self):
        return self.head

    def end(self):
        return self.tail



n, m = map(int, input().split())
s = input()

dll = DoublyLinkedList()

for i in s:
    dll.push_back(i)

it = dll.end()

for _ in range(m):
    line = list(input().split())
    
    if line[0] == 'L':
        if it != dll.begin():
            it = it.prev
    elif line[0] == "R":
        if it != dll.end():
            it = it.next 
    elif line[0] == "D":
        if it != dll.end():
            it = dll.erase(it)

    elif line[0] == "P":
        dll.insert(it, line[1])
        

it = dll.begin()
while it != dll.end():
    print(it.data, end="")
    it = it.next