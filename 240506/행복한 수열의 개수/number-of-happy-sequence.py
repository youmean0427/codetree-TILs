n, m = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
ans = 0

def lucky (arr, m):
    global ans
    for i in range(len(arr)-m+1):
        x = arr[i:i+m]
        if x.count(x[0]) == m:
            ans += 1
            return

def find(arr, m):
    for a in arr:
        lucky(a, m)
        
find(arr, m)

col_arr = []
for i in range(n):
    col_in = []
    for j in range(n):
        col_in.append(arr[j][i])
    col_arr.append(col_in)

find(col_arr, m)

print(ans)