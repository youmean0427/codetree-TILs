import heapq

n = int(input())
q = []
for _ in range(n):
    x = list(input().split())
    y = x[0]
    if y == 'push':
        heapq.heappush(q, -int(x[1]))
    
    elif y == 'pop':
        print(-heapq.heappop(q))
    
    elif y == 'size':
        print(len(q))
    
    elif y == 'empty':
        if q:
            print(0)
        else:
            print(1)
    
    elif y == 'top':
        print(-q[0])