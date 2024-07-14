from collections import deque

class Queue:
    def __init__(self):
        self.dq = deque()
    
    def push(self, item):
        self.dq.append(item)
    
    def empty(self):
        return not self.dq
    
    def size(self):
        return len(self.dq)

    def pop(self):
        if self.empty():
            raise Exception("Queue is Empty")
        
        return self.dq.popleft()

    def front(self):
        if self.empty():
            raise Exception("Queue is Empty")
        
        return self.dq[0]
    

n= int(input())

dq = Queue()
for _ in range(n):
    line = list(input().split())

    x = line[0]
    
    if x == "push":
        dq.push(int(line[1]))
    
    elif x == "empty":
        if (dq.empty()):
            print(1)
        else:
            print(0)

    elif x == "size":
        print(dq.size())
    
    elif x == "pop":
        print(dq.pop())
    
    elif x == "front":
        print(dq.front())