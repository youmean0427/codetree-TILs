from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))
s = SortedSet([i for i in range(1, m+1)])
visited = [0] * m

arr.sort()
cnt = 0

for i in arr:

    idx = s.bisect_left(i)

    while idx >= 0:
        if visited[idx] == 0:
            visited[idx] = 1
            cnt += 1
            break
        else:
            idx -= 1

print(cnt)