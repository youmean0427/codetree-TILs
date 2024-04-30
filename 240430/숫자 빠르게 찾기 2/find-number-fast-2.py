from sortedcontainers import SortedSet
n, m = map(int, input().split())
s = SortedSet()
x = list(map(int, input().split()))

for i in x:
    s.add(i)

for _ in range(m):
    y = int(input())
    
    idx = s.bisect_left(y)
    if idx < len(s):
        print(s[idx])
    else:
        print(-1)