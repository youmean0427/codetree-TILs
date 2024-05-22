n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

q = []
for _ in range(k):
    a, b = map(int, input().split())
    q.append((a, b))

visited = []

dir = [(0, 1), (1, 0), (-1, 0), (0, -1)]

def bfs():

    while q:
        x, y = q.pop(0)

        for dn, dm in dir:
            dnx, dmy = dn + x, dm + y
            if 0 <= dnx < n and 0 <= dmy < n:
                if (dnx, dmy) not in visited and arr[dnx][dmy] == 0:
                    visited.append((dnx, dmy))
                    q.append((dnx, dmy)) 

bfs()
print(len(visited))