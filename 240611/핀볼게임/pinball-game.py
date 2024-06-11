n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 1 : / 
# 2 : \
start= [ ]

for i in range(n):
    for j in range(n):

        if i == 0:
            start.append((i, j, "D"))

        if i == n-1:
            start.append((i, j, "U"))
        
        if j == 0:
            start.append((i, j, "R"))
        
        if j == n-1:
            start.append((i, j, "L"))
            
dir = {"R" : (0, 1), "L" : (0, -1), "U": (-1, 0), "D": (1, 0)}
wall = [{}, {"D": "L", "L": "D", "U": "R", "R": "U"}, {"D": "R", "R": "D", "U": "L", "L": "U"}]

def ball (sn, sm, d):

    time = 1
    now_n = sn
    now_m = sm
    now_d = d

    if (arr[now_n][now_m] == 1):
        now_d = wall[1][now_d]
    elif (arr[now_n][now_m] == 2):
        now_d = wall[2][now_d]

    cnt = 0
    while cnt < n*n:
        
        dn, dm = now_n + dir[now_d][0], now_m + dir[now_d][1]

        if (0 <= dn < n and 0 <= dm < n):
            time += 1
            if (arr[dn][dm] == 1):
                now_d = wall[1][now_d]
            elif (arr[dn][dm] == 2):
                now_d = wall[2][now_d]
            
            
            now_n = dn
            now_m = dm

        else:
            time += 1
            return time
        
        cnt += 1
    return time

ans = 0
for a, b, c in start:
    x = ball(a, b, c)
    ans = max(ans, x)
print(ans)