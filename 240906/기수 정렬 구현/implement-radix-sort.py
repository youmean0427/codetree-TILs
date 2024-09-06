n = int(input())
arr = list(input().split())
k = len(arr[0])

for pos in range(k-1, -1, -1):
    arr_new = [[] for _ in range(10)]
    for i in range(0, n):
        x = arr[i][pos]
        arr_new[int(x)].append(arr[i])

    store_arr = []
    for i in range(0, 10):
        for j in range(0, len(arr_new[i])):
            store_arr.append(arr_new[i][j])

    arr = store_arr

for i in arr:
    print(int(i), end = ' ')