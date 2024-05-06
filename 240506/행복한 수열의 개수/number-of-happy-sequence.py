n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
ans = 0

def find(arr, m):
    global ans
    for a in arr:
        x = a[0]
        max_cnt = 1
        cnt = 1
        for i in range(1, len(a)):
            if a[i] == x:
                cnt += 1
            else:
                x = a[i]
                cnt = 1
            max_cnt = max(max_cnt, cnt)

        if max_cnt >= m:
            ans += 1

find(arr, m)

col_arr = []
for i in range(n):
    col_in = []
    for j in range(n):
        col_in.append(arr[j][i])
    col_arr.append(col_in)

find(col_arr, m)

print(ans)