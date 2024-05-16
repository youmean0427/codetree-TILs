n = int(input())
visited = [0] * (n+1)

def back(cnt, sm):

    if cnt >= n:
        print(*sm)
        return
    
    for i in range(1, n+1):
        if visited[i] == 0:
            visited[i] = 1
            back(cnt+1, sm+[i])
            visited[i] = 0

back(0, [])