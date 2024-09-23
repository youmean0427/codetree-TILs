n = int(input())
arr = list(map(int, input().split()))

def heapify(n, i):
    largest = i
    right = i * 2
    left = i * 2 + 1

    if right < n and arr[right] > arr[largest]:
        largest = right
    if left < n and arr[left] > arr[largest]:
        largest = left

    if largest != i:
        arr[largest], arr[i] = arr[i], arr[largest]
        heapify(n, i)

for i in range(n//2, -1, -1):
    heapify(n, i)

for i in range(n-1, -1, -1):
    arr[0], arr[i] = arr[i], arr[0]
    heapify(i-1, 0)
print(*arr)