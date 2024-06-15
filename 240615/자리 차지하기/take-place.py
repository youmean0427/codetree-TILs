from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()

for i in range(1, m+1):
    s.add(i)

arr = list(map(int, input().split()))

cnt = 0
for i in arr:
    idx = s.bisect_left(i)
    if idx == len(s):
        s.remove(s[idx-1])
        cnt += 1
        continue

    s.remove(s[idx])
    cnt += 1

 
print(cnt)