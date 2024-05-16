n = int(input())
arr = list(map(int, input().split()))
visited = [0] * (2*n)

def now_visited(visited):

    total = 0
    for i in range(2*n):
        if visited[i] == 0:
            total += arr[i]
    return total

ans = float('inf')

def back(cnt, sm):
    global ans

    if cnt >= n:
        if len(sm) == n:
            ans = min(ans, abs(sum(sm) - now_visited(visited)))
        return
    
    for i in range(2*n):
        if visited[i] == 0:
            visited[i] = 1
            back(cnt+1, sm+[arr[i]])
            visited[i] = 0
        back(cnt+1, sm)
    
back(0, [])
print(ans)