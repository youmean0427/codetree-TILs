n = int(input())
arr = [[] for _ in range(n+1)]
parent = [0] * (n+1)
for _ in range(n-1):
    x, y = map(int, input().split())
    arr[x].append(y)

def bfs():

    q = [1]
    while q:
        p = q.pop(0)
        for i in arr[p]:
            parent[i] = p
            q.append(i)

bfs()
for i in range(2, len(parent)):
    print(parent[i])