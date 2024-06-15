from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()
pos = {}
for _ in range(n):
    x, y = map(int, input().split())
    s.add(x)
    if x in pos:
        pos[x].append(y)
        pos[x].sort()
    else:
        pos[x] = [y]

for _ in range(m):
    k = int(input())
    idx = s.bisect_left(k)
    
    if idx >= len(s):
        print(-1, -1)
    else:
        print(s[idx], pos[s[idx]][0])
        pos[s[idx]].pop(0)

        if len(pos[s[idx]]) == 0:
            s.remove(s[idx])