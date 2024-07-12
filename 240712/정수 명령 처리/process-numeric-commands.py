class Stack:

    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)
    
    def empty(self):
        return not self.items
    
    def size(self):
        return len(self.items)
    
    def pop(self):
        if (self.empty()):
            raise Exception("Stack is empty")
        
        return self.items.pop()
    
    def top(self):
        if (self.empty()):
            raise Exception("Stack is empty")
        
        return self.items[-1]



n = int(input())
stack = Stack()
for i in range(n):

    line = list(input().split())

    x = line[0]
    if len(line) == 2:
        y = line[1]

    if x == "push":
        stack.push(y)
    elif x == "size":
        print(stack.size())
    elif x == "empty":
        print(1 if stack.empty() else 0)
    elif x == "pop":
        print(stack.pop())
    elif x == "top":
        print(stack.top())