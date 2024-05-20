N, M = map(int, input().split())
arr = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

def dfs(start):

    stack = [start]
    visited = [0] * (N+1)
    while stack:
        s = stack.pop()

        if visited[s] == 0:
            visited[s] = 1

        for i in arr[s]:
            if visited[i] == 0:
                stack.append(i)
    return visited

v = dfs(1)
print(sum(v)-1)