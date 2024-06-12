n, m, t, k = map(int, input().split())

arr = [[[] for _ in range(n)] for _ in range(n)]
balls = []
for i in range(1, m+1):
    r, c, d, v = map(str, input().split())
    r, c, v = int(r)-1, int(c)-1, int(v)
    arr[r][c].append((i, d, v))
    balls.append((r, c, i, d, v))

dir = {"R": (0, 1), "L": (0, -1), "U": (-1, 0), "D": (1, 0)}
c_dir = {"R": "L", "L": "R", "U": "D", "D": "U"}

def move(ball):
    
    mr, mc = ball[0], ball[1]
    mi, md, mv = ball[2], ball[3], ball[4]

    
    while mv > 0:
        
        dx, dy = mr + dir[md][0], mc + dir[md][1]
        if 0 <= dx < n and 0 <= dy < n:
            mr = dx
            mc = dy
        else:
            md = c_dir[md]
            mv += 1

        mv -= 1
        
    return (mr, mc, mi, md, ball[4])

def prior(p_arr):
    
    for i in range(n):
        for j in range(n):
            p_arr[i][j].sort(key= lambda x:(-x[2], -x[0]))
            p_arr[i][j] = p_arr[i][j][:k]
    return p_arr

while t > 0:
    t -= 1
    arr = [[[] for _ in range(n)] for _ in range(n)]
    temp_balls = []
    while balls:
        x = balls.pop(0)
        res = move(x)

        arr[res[0]][res[1]].append((res[2], res[3], res[4]))
    
    arr = prior(arr)
    for i in range(n):
        for j in range(n):
            if arr[i][j]:
                for a in arr[i][j]:
                    temp_balls.append((i, j, a[0], a[1], a[2]))
    
    balls = temp_balls

ans = 0
for i in range(n):
    for j in range(n):
        ans += len(arr[i][j])
print(ans)