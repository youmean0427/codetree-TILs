import heapq
n, m = map(int, input().split())
arr = list(map(int, input().split()))

pq = []
for i in arr:
    heapq.heappush(pq, -i)

for _ in range(m):
    x = -heapq.heappop(pq) - 1
    heapq.heappush(pq, -x)
print(-pq[0])