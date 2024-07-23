class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None
    
class Double:
    def __init__(self):
        self.head = None
        self.tail = None

    def push_back(self, data):
        new_node = Node(data)
        if self.tail == None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def connect(self):
        self.tail.next = self.head
        self.head.prev = self.tail 


n, q = map(int, input().split())
arr = list(input().split())
db = Double()

for i in arr:
    db.push_back(i)

db.connect()


for _ in range(q):
    line = list(input().split())
    num = int(line[0])

    if num == 1:
        db.head = db.head.next
    elif num == 2:
        db.head = db.head.prev
    elif num == 3:
        db.head.next.next.prev = db.head
        db.head.next = db.head.next.next

    elif num == 4:
        new_node = Node(line[1])

        new_node.prev = db.head
        new_node.next = db.head.next
        db.head.next.prev = new_node
        db.head.next = new_node


    if db.head.prev.data == db.head.next.data:
        print(-1)
    else:
        print(db.head.prev.data, db.head.next.data)