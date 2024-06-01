from collections import deque
N = int(input())

visited = [float('inf')] * (2*N)
def bfs(n):
    
    visited[n] = 1
    q = deque([[n, 0]])
    if n == 1:
        print(0)
        return

    while q:
        x, cnt = q.popleft()
       
        if x == 1:
            print(visited[x])
            return

        if visited[x-1] > cnt+1:
            visited[x-1] = cnt+1
            q.append([x-1, cnt+1])

        if visited[x+1] > cnt+1:
            visited[x-1] = cnt+1
            q.append([x+1, cnt+1])

        if x % 2 == 0:
            if visited[x//2] > cnt+1: 
                visited[x//2] = cnt+1
                q.append([x // 2, cnt+1])

        if x % 3 == 0:
            if visited[x//3] > cnt + 1:
                visited[x//3] = cnt+1
                q.append([x // 3, cnt+1])
    
bfs(N)