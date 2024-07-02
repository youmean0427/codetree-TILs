from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))
s = SortedSet([i for i in range(1, m+1)])
visited = [0] * m

arr.sort()
cnt = 0

for i in arr:

    idx = s.bisect_right(i)-1
    if idx >= 0:
        s.remove(s[idx])
        cnt += 1
    
print(cnt)