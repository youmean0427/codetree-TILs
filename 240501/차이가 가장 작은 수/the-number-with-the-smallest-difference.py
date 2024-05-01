from sortedcontainers import SortedSet
n, m = map(int, input().split())
s = SortedSet()

for _ in range(n):
    x = int(input())
    s.add(x)

ans = float('inf')
for i in range(len(s)):
    idx = s.bisect_left(s[i]+m)
    if idx < len(s):
        ans = min(ans, s[idx] - s[i])

if ans == float('inf'):
    print(-1)
else:
    print(ans)