n = int(input())
visited = [0] * (n+1)

def backtracking(cnt, sm):
    
    if cnt >= n:
        print(*sm)
        return
    
    for i in range(n, 0, -1):
        if visited[i] == 0:
            visited[i] = 1
            backtracking(cnt+1, sm+[i])
            visited[i] = 0

backtracking(0, [])