N = int(input())
arr = [list(input()) for _ in range(N)]

coins = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 'S':
            start = (i, j)
        elif arr[i][j] == 'E':
            end = (i, j)
        elif arr[i][j] != '.':
            arr[i][j] = int(arr[i][j])
            coins.append((i, j))

ans = float('inf')
def back(sn, sm, now, dis, cnt):
    global ans

    if cnt == 3:
        dis += abs(sn - end[0]) + abs(sm - end[1])
        ans = min(ans, dis)
        return

    for cn, cm in coins:
        if arr[cn][cm] > now:
            dis += abs(cn - sn) + abs(cm - sm) 
            back(cn, cm, arr[cn][cm], dis, cnt+1)
            dis -= abs(cn - sn) + abs(cm - sm)
    
back(start[0], start[1], 0, 0, 0)
if ans == float('inf'):
    print(-1)
else:
    print(ans)