n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

visited = [0] * n
ans = 0
def back(cnt, sm, idx):
    global ans
    if cnt == n:
        ans = max(ans, sum(sm)) 
        return

    for i in range(n):
        if visited[i] == 0:
            visited[i] = 1
            back(cnt+1, sm+[arr[idx][i]], idx+1)
            visited[i] = 0

back(0, [], 0)
print(ans)