n, t = map(int, input().split())
arr = []
for _ in range(2):
    for a in list(map(int, input().split())):
        arr.append(a)

while t > 0:
    x = arr[len(arr)-1]
    
    for i in range(len(arr)-1, -1, -1):
        arr[i] = arr[i-1]
    
    arr[0] = x
    t -= 1

print(*arr[:n])
print(*arr[n:])