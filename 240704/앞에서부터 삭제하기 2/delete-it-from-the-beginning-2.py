import heapq

n = int(input())
arr = list(map(int, input().split()))

ans = 0
for i in range(1, n-1):
    x = arr[i:]

    heap = []
    for j in x:
        heapq.heappush(heap, j)

    y = heap[1:]
    ans = max(ans, sum(y) / len(y))


print(f"{ans:.2f}")