import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

n, m, t = map(int, input().split())
arr = []
cnt = [[0 for _ in range(n)] for _ in range(n)]


for _ in range(n):
    line = list(map(int, input().split()))
    arr.append(line)

for _ in range(m):
    a, b = map(int, input().split())
    cnt[a-1][b-1] = 1

def max_value(x, y):
    max_val = 0
    max_pos = [0, 0]
    dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    for dx, dy in dir:
        dxx = dx + x
        dyy = dy + y
        if 0 <= dxx < n and 0 <= dyy < n:
            if arr[dxx][dyy] > max_val:
                max_val = arr[dxx][dyy]
                max_pos = [dxx, dyy]
    return max_pos

def check_balls(cnt):

    for x in range(len(cnt)):
        for y in range(len(cnt)):
            if cnt[x][y] >= 2:
                cnt[x][y] = 0

    return cnt

for time in range(t):
    next_cnt = [[0 for _ in range(n)] for _ in range(n)]

    for x in range(n):
        for y in range(n):
            if cnt[x][y] == 1:
                mx, my = max_value(x, y)
                next_cnt[mx][my] += 1

    check_ball = check_balls(next_cnt)
    cnt = check_ball[:]

ans = 0
for c in cnt:
    ans += c.count(1)
print(ans)