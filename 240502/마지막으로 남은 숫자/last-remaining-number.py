import heapq
n = int(input())
pq = []
for i in list(map(int, input().split())):
    heapq.heappush(pq, -i)

while len(pq) >= 2:
    x = -heapq.heappop(pq)
    y = -heapq.heappop(pq)

    if x != y:
        heapq.heappush(pq, -(x - y))

if pq:
    print(-pq[0])
else:
    print(-1)