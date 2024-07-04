N, M, C = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]

# M개의 연속한 물건
# C의 최대무게

def multi(sm):
    total = 0
    for i in sm:
        total += i * i
    return total

# 물건은 연속적이지 않아도됨
def back(b_arr, cnt, sm, start):
    global max_val, pos
    if cnt >= len(b_arr):
        if sum(sm) <= C:
            if max_val < multi(sm):
                max_val = multi(sm)
                pos = start
        return
    
    back(b_arr, cnt+1, sm+[b_arr[cnt]], start)
    back(b_arr, cnt+1, sm, start)

ans = 0
pos = (0, 0)
for i in range(N):
    for j in range(N-M+1):

        res = 0
        max_val = 0
        visited[i][j:j+M] = [1] * M
        line = arr[i][j:j+M]
        back(line, 0, [], (i, j))
        
        res += max_val

        pos = (0, 0)
        s_max = 0
        
        for a in range(N):
            for b in range(N-M+1):
                max_val = 0
                if 1 in visited[a][b:b+M]:
                    continue
                else:
                    line = arr[a][b:b+M]
                    back(line, 0, [], (a, b))
                s_max = max(s_max, max_val)
                
        res += s_max
        visited[i][j:j+M] = [0] * M
        ans = max(ans, res)
print(ans)