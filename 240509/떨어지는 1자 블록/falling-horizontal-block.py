n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
k -= 1
c = k + m - 1

def line(b_arr, arr):
    for i in range(n):
        for j in range(n):
            if b_arr[j] == 1 and arr[i][j] == 1:
                return i - 1 
    return i
    
def change(b_arr, arr, idx):
    for i in range(len(b_arr)):
        if b_arr[i] == 1:
            arr[idx][i] = b_arr[i]
    return arr

def block(arr):
    b = [0] * n
    for i in range(k, c+1):
        b[i] = 1
    d = line(b, arr)
    arr = change(b, arr, d)
    return arr   

for i in block(arr):
    print(*i)