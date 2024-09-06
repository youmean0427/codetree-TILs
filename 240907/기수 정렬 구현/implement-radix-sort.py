n = int(input())
arr = list(map(int, input().split()))
k = 6
p = 1
for pos in range(k-1, -1, -1):
    arr_new = [[] for _ in range(10)]
    for i in range(0, n):
        x = (arr[i] // p) % 10
        arr_new[x].append(arr[i])

    store_arr = []
    for i in range(0, 10):
        for j in range(0, len(arr_new[i])):
            store_arr.append(arr_new[i][j])
    p *= 10
    arr = store_arr

for i in arr:
    print(int(i), end = ' ')