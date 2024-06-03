from collections import deque
n = int(input())
arr = [ list(map(int, input().split())) for _ in range(n) ]

r, c, m1, m2, m3, m4, dir = map(int, input().split())
r, c = r-1, c-1
m = [m1, m2, m3, m4]
move = [(-1, 1), (-1, -1), (1, -1), (1, 1)]

v = deque([])
p = []
for d in range(4):
    for k in range(m[d]):
        v.append(arr[r][c])
        p.append((r, c))    
        r += move[d][0]
        c += move[d][1]

if dir == 0:
    v.rotate(1)
else:
    v.rotate(-1)

for i in range(len(v)):
    arr[p[i][0]][p[i][1]] = v[i]

for a in arr:
    print(*a)