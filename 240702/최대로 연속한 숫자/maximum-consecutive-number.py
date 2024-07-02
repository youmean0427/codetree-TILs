from sortedcontainers import SortedSet

n, m = map(int, input().split())
arr = list(map(int, input().split()))

s = SortedSet([i for i in range(n+1)])

k = SortedSet()
k.add(-1)
k.add(n+1)


for i in arr:
    k.add(i)

    ans = 0
    for j in range(len(k)-1,0, -1):
        res = k[j] - k[j-1] - 1
        ans = max(ans, res)
    
    print(ans)