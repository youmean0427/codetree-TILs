from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))
s = SortedSet([i for i in range(1, m+1)])

cnt = 0

for i in arr:
    idx = s.bisect_right(i)
    if idx > 0: 
        s.remove(s[idx - 1])
        cnt += 1
    else:
        break
    
print(cnt)