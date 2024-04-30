from sortedcontainers import SortedSet
n, m = map(int, input().split())
s = SortedSet()

for _ in range(n):
    x, y = map(int, input().split())
    s.add((x, y))

for _ in range(m):
    nx, ny = map(int, input().split())
    
    idx = s.bisect_left((nx, ny))
    
    if idx < len(s):
        print(*s[idx])
    else:
        print(-1, -1)