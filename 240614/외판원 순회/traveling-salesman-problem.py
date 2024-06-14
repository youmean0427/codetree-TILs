n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

visited = [0] * n
ans = float('inf')
def back(cnt, sm, now):
    global ans
    # print(cnt, sm, now)
    if cnt >= n-1:
        ans = min(ans, sum(sm) + arr[now][0])
        return

    for i in range(n):
        if i != now:
            if (visited[i] == 0):
                visited[now] = 1
                visited[i] = 1
                back(cnt+1, sm+[arr[now][i]], i)
                visited[i] = 0
    

back(0, [], 0)
print(ans)