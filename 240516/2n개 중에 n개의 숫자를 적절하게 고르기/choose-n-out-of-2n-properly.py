n = int(input())
arr = list(map(int, input().split()))
visited = [0] * (2*n)


ans = float('inf')
def back(cnt, sm):
    global ans

    if ans < abs(sum(arr) - sum(sm) - sum(sm)):
        return

    if cnt >= n:
        if len(sm) == n:
            ans = min(ans, abs(sum(arr) - sum(sm) - sum(sm)))
        return
    
    for i in range(2*n):
        if visited[i] == 0:
            visited[i] = 1
            back(cnt+1, sm+[arr[i]])
            visited[i] = 0
        back(cnt+1, sm)
    
back(0, [])
print(ans)