n = int(input())
arr = [[] for _ in range(n+1)]
for _ in range(n-1):
    x, y, z = map(int, input().split())
    
    arr[x].append((y, z))
    arr[y].append((x, z))

def dfs(start):
    visited = [0 for _ in range(n+1)]
    stack = [(start, 0)]
    max_val = [0, 0]
    
    while (stack):
        x, y = stack.pop()
        visited[x] = 1

        if (max_val[1] < y):
            max_val[0] = x
            max_val[1] = y

        for ax, ay in arr[x]:
            
            if (visited[ax] == 0):
                stack.append((ax, ay+y))

    return max_val

ans = dfs(1)
ans = dfs(ans[0])
print(ans[1])