n, m = map(int, input().split())

tromino = [
[(0, 0), (1, 0), (1, 1)], [(0, 0), (1, 0), (1, -1)],
[(0, 0), (0, 1),(-1, 1)], [(0, 0), (-1, 0), (-1, -1)], 
[(0, 0), (0, -1), (1, -1)], [(0, 0), (0, -1), (-1, -1)],
[(0, 0), (-1, 0), (-1, 1)], [(0, 0), (0, 1), (1, 1)],

[(0, 0), (1, 0), (2, 0)], [(0, 0), (0, 1), (0, 2)],
[(0, 0),(-1, 0), (-2, 0)], [(0, 0), (0, -1), (0, -2)]
]

arr = []
ans = 0

for _ in range(n):
    arr.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):

        for t in tromino:
            tro_res = 0
            cnt = 0
            for x, y in t:
                if 0 <= i + x < n and 0 <= j+y < m:
                    tro_res += arr[i+x][j+y]
                    cnt += 1

            if cnt == 3:
                ans = max(ans, tro_res)

print(ans)