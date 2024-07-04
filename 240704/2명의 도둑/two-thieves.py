N, M, C = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]

# M개의 연속한 물건
# C의 최대무게


def math(arr):
    total = 0
    weight = 0
    for i in arr:
        weight += i
        total += i * i
        if weight > C:
            weight -= i
            total -= i * i
    return total

def back(cnt, sm, row, idx, location):
    global first, first_loca

    if cnt == M:    
        if first < math(*sm):
            first = math(*sm)
            first_loca = location[0] 
            
        return
    
    for i in range(N-M+1):
        if visited[row][i:i+M] == [0] * M:
            sm.append(arr[row][i:i+M])
            location.append((row, i))
            back(cnt+M, sm, row, idx, location)
            location.pop()
            sm.pop()

ans = 0
for _ in range(2):
    first = 0
    first_loca = (0, 0)

    for i in range(N):
        back(0, [], i, 0, [])

    start_x = first_loca[0]
    start_y = first_loca[1]

    for i in range(start_y, start_y+M):
        visited[start_x][i] = 1

    ans += first

print(ans)