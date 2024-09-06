n = int(input())
arr = list(input().split())

k = 0
for i in arr:
    k = max(len(i), k)

for i in range(n):
    if (len(arr[i]) < k):
        x = ''
        while (len(x) + len(arr[i]) != k):
            x += '0'
        arr[i] = x + arr[i]

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