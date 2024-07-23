class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


class Double:
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0

    def push_back(self, data):
        new_node = Node(data)

        if (self.tail != None):
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node
        
        else:
            self.head = new_node
            self.tail = new_node
            new_node.prev = None
            
        self.count += 1



n, k = map(int, input().split())
q = int(input())
shelf = [0] * (k+1)

for i in range(1, k+1):
    shelf[i] = Double()

for i in range(1, n+1):
    shelf[1].push_back(i)
    
for i in range(q):
    x, a, b = map(int, input().split())

    if x == 1:
        
        if shelf[a].head:
            sh = shelf[a].head
            shelf[a].head.next.prev = None
            shelf[a].head = shelf[a].head.next
            sh.next = None

            if shelf[b].tail:
                sh.prev = shelf[b].tail
                shelf[b].tail.next = sh
                shelf[b].tail = sh
            else:
                shelf[b].head = sh
                shelf[b].tail = sh
                sh.prev = None

            shelf[b].count += 1
            shelf[a].count -= 1

    elif x == 2:
         if shelf[a].tail:
            sh = shelf[a].tail
            shelf[a].tail.prev.next = None
            shelf[a].tail = shelf[a].tail.prev
            sh.prev = None

            if shelf[b].head:
                sh.next = shelf[b].head
                shelf[b].head.prev = sh
                shelf[b].head = sh
            else:
                shelf[b].head = sh
                shelf[b].tail = sh
                sh.prev = None

            shelf[b].count += 1
            shelf[a].count -= 1

    elif x == 3:
        if shelf[a].tail:
            sh = shelf[a].head
            st = shelf[a].tail
            shelf[a].tail = None
            shelf[a].head = None

            if shelf[b].head:
                shelf[b].head.prev = st
                st.next = shelf[b].head
                shelf[b].head = sh
            else:
                shelf[b].head = sh
                shelf[b].tail = st

            if a != b:    # 같은 책꽂이가 아닐 경우에만, 실행
                shelf[b].count += shelf[a].count
                shelf[a].count = 0

    elif x == 4:
        if shelf[a].head:
            sh = shelf[a].head
            st = shelf[a].tail
            shelf[a].tail = None
            shelf[a].head = None

            if shelf[b].tail:
                shelf[b].tail.next = sh
                sh.prev = shelf[b].tail
                shelf[b].tail = st
            else:
                shelf[b].head = sh
                shelf[b].tail = st
            if a != b:
                shelf[b].count += shelf[a].count
                shelf[a].count = 0



for i in range(1, k+1):
    x = shelf[i].head
    print(shelf[i].count, end = " ")
    while x != None:
        print(x.data, end = " ")
        x = x.next
    print()