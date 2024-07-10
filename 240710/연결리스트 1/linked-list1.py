class Node:
    def __init__(self, data):
        self.data = data 
        self.prev = None
        self.next = None

# p의 앞에 n을 삽입        
def insert_prev(p, n):
    n.next = p
    n.prev = p.prev

    if p.prev is not None:
        p.prev.next = n
    p.prev = n

# p의 뒤에 n을 삽입
def insert_next(p, n):
    n.next = p.next
    n.prev = p

    if p.next is not None:
        p.next.prev = n
    p.next = n

s_init = input()
cur = Node(s_init)
n = int(input())
for _ in range(n):
    line = input().split(" ")

    if line[0] == "1":
        new_node = Node(line[1])
        insert_prev(cur, new_node )
        
    
    if line[0] == "2":
        new_node = Node(line[1])
        insert_next(cur, new_node)
    
    if line[0] == "3":
        if cur.prev != None:
            cur = cur.prev
     
    if line[0] == "4":
        if cur.next != None:
            cur = cur.next
        
    if cur.prev == None:
        cur_prev = "(Null)"
    else:
        cur_prev = cur.prev.data
    if cur.next == None:
        cur_next = "(Null)"
    else:
        cur_next = cur.next.data
        
    print(cur_prev, cur.data, cur_next)