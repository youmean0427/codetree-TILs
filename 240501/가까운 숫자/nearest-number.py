from sortedcontainers import SortedSet
n = int(input())
arr = list(map(int, input().split()))
s = SortedSet([0])

ans = float('inf')
for i in arr:
    s.add(i)
    idx = s.bisect_right(i)-1
    ans = min(s[idx]-s[idx-1], ans)
    if idx+1 < len(s):
        ans = min(s[idx+1]-s[idx],ans)
    print(ans)