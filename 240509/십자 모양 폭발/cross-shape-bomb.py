n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
sn, sm = map(int, input().split())

def gravity(arr):
    tg_arr = []
    for a in range(n):
        g_arr = []
        for b in range(n-1, -1, -1):
            if arr[b][a] != 0:
                g_arr.append(arr[b][a])
        
        while len(g_arr) < n:
            g_arr.append(0)
        g_arr.reverse()
        tg_arr.append(g_arr)

    return tg_arr
            

def bomb(sn, sm, arr):
    b_arr = arr
    cnt = arr[sn][sm] - 1
    b_arr[sn][sm] = 0
    for i in range(sm, sm+cnt+1):
        if 0 <= i < n:
            b_arr[sn][i] = 0
    
    for i in range(sm-cnt, sm):
        if 0 <= i  < n:
            b_arr[sn][i] = 0
    
    for i in range(sn, sn+cnt+1):
        if 0 <= i  < n:
            b_arr[i][sm] = 0
    
    for i in range(sn-cnt, sn):
        if 0 <= i < n:
            b_arr[i][sm] = 0

    return gravity(b_arr)

g = bomb(sn-1, sm-1, arr)
for i in range(n):
    for j in range(n):
        print(g[j][i], end = " ")
    print()