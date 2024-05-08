from collections import deque
n, t = map(int, input().split())
arr = deque([])
for _ in range(3):
    for a in list(map(int, input().split())):
        arr.append(a)

while t > 0:
    x = arr.pop()
    arr.appendleft(x)
    t -= 1

for i in range(n):
    print(arr[i], end=" ")
print()
for i in range(n, 2*n):
    print(arr[i], end=" ")
print()
for i in range(2*n, len(arr)):
    print(arr[i], end=" ")