import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

n = int(input())
arr = []
ans = float('inf')
for _ in range(n):
    x, y = map(int, input().split())
    arr.append((x, y))

def dfs(idx, sm, select, jump):
    global ans
    if idx >= n-1:
        if len(select) <= n-2:
            sm += abs(select[-1][0] - arr[-1][0]) + abs(select[-1][1] - arr[-1][1])
            select += [arr[-1]]
            ans = min(ans, sm)
        return

    if idx == 1:
        dfs(idx+1, sm+abs(select[-1][0]-arr[idx][0]) + abs(select[-1][1] - arr[idx][1]), select+[arr[idx]], jump)
        dfs(idx+1, sm, select, jump+1)
    elif jump:
        dfs(idx+1, sm+abs(select[-1][0]-arr[idx][0]) + abs(select[-1][1] - arr[idx][1]), select+[arr[idx]], jump)
    else:
        dfs(idx+1, sm+abs(select[-1][0]-arr[idx][0]) + abs(select[-1][1] - arr[idx][1]), select+[arr[idx]], jump)
        dfs(idx+1, sm, select, jump+1)

dfs(1, 0, [arr[0]], 0)
print(ans)