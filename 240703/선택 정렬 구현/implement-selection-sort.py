n = int(input())
arr = list(map(int, input().split()))

for i in range(n):
    
    for j in range(i+1, n):

        if arr[j] < arr[i]:
            arr[j], arr[i] = arr[i], arr[j]

print(*arr)