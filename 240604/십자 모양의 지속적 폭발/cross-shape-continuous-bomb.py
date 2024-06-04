n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

col = []
for _ in range(m):
    col.append(int(input())-1)

def temp_copy():
    temp = [[0  for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            temp[i][j] = arr[i][j]
    return temp

def explode(sn, sm):
    global arr
    
    while arr[sn][sm] == 0:
        sn += 1
        if sn >= n or sn < 0:
            return

    
    temp = temp_copy()
    


    dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    cnt = 1
    temp[sn][sm] = 0
    while cnt < arr[sn][sm]:
        for d in dir:
            dn = sn + d[0] * cnt
            dm = sm + d[1] * cnt

            if 0 <= dn < n and 0 <= dm < n:
                temp[dn][dm] = 0
        cnt += 1
    g_arr = gravity(temp)
    arr = g_arr

def gravity(g_arr):

    total = []
    for j in range(n):
        temp = []
        for i in range(n-1, -1, -1):
            if g_arr[i][j] == 0:
                continue
            else:
                temp.append(g_arr[i][j])

        while len(temp) < n:
            temp.append(0)
        total.append(temp)
            
    for i in range(n):
        for j in range(n):
            g_arr[(n-1)-j][i] = total[i][j]
 
    return g_arr

            
row = 0
type = 0

for c in col:
    explode(row, c)
 
        
    

for a in arr:
    print(*a)