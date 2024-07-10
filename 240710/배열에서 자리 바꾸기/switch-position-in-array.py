class Node:

    def __init__(self, num):
        self.data = num
        self.prev = None
        self.next = None


n = int(input())
q = int(input())

node = [None] + [Node(i) for i in range(1, n+1)] + [None]


for i in range(1, n+1):
    node[i].prev = node[i-1]
    node[i].next = node[i+1]


def connect(s, e):
    if s is not None:
        s.next = e
    if e is not None:
        e.prev = s

for _ in range(q):
    a, b, c, d = map(int, input().split())

    a_prev = node[a].prev
    c_prev = node[c].prev
    connect(a_prev, node[c])
    connect(c_prev, node[a]) 

    b_next = node[b].next
    d_next = node[d].next
    connect(node[d], b_next)
    connect(node[b], d_next)


head = 0
for i in range(1, n+1):
    if node[i].prev == None:
        head = i

it = node[head]

while it != None:
    print(it.data, end = " ")
    it = it.next