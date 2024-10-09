n = int(input())
inp = list(map(int, input().split()))
x = int(input())
edges = [[] for _ in range(n)]
deleted = [0 for _ in range(n)]

deleted[x] = 1
ans = 0

for i in range(n):
    x, y = i, inp[i]
    if y == -1:
        root = x
        continue
    edges[y].append(x)

def dfs(x):
    global ans
    if (deleted[x]):
        return
    
    leaf = 1
    for i in edges[x]:
        if deleted[i] == 0:
            dfs(i)
            leaf = 0

    if (leaf):
        ans += 1

dfs(root)
print(ans)