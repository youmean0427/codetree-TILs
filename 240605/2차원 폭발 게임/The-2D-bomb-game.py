n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

temp = [[0 for _ in range(n)] for _ in range(n)]

def copy():

    for i in range(n):
        for j in range(n):
            temp[i][j] = arr[i][j]

def gravity(arr):
    g_arr = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        now_row = n-1
        for j in range(n-1, -1, -1):
            if arr[j][i]:
                g_arr[now_row][i] = arr[j][i]
                now_row -= 1
    return g_arr

def rotate(arr):
    r_arr = [[0 for _ in range(n)] for _ in range(n)]

    for i in range(n):
        for j in range(n):
            r_arr[i][j] = arr[(n-1)-j][i]
    return r_arr

while k >= 0:
    copy()
    for i in range(n):
        
        start = 0
        end = 0
        check = False

        while end < n:
            if arr[start][i] == arr[end][i]:
                end += 1
                check = True
            else:
                if end - start >= m:
                    for row in range(start, end):
                        temp[row][i] = 0
                start = end
                end = start+1
                check = False
        
        if check:
            for row in range(start, end):
                temp[row][i] = 0
    
    g_arr = gravity(temp)
    r_arr = rotate(g_arr)
    g_arr = gravity(r_arr)
    arr = g_arr

    k-=1


ans = 0
for i in range(n):
    for j in range(n):
        if arr[i][j]:
            ans += 1
print(ans)