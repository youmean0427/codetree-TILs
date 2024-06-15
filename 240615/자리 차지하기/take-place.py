from sortedcontainers import SortedSet

n, m = map(int, input().split())
s = SortedSet()

for i in range(1, m+1):
    s.add(i)

arr = list(map(int, input().split()))

visited = [0] * (m+1)

for i in arr:
    idx = s.bisect_left(i)
    flag = 0
    while idx > -1:
        if visited[idx] == 0:
            visited[idx] = 1
            flag = 1
            break
        else:
            idx -= 1
    
    if flag == 0:
        print(sum(visited))
        exit(0)

print(sum(visited))