n, m  = map(int, input().split())
dots = list(map(int, input().split()))
lines = []

for _ in range(m):
    lines.append(list(map(int, input().split())))

for line in lines:

    start = line[0]
    end = line[1]
    cnt = 0
    for dot in dots:
        if start <= dot and dot <= end:
            cnt += 1

    
    print(cnt)