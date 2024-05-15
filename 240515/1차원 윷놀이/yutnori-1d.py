n, m, k = map(int, input().split())
arr = list(map(int, input().split()))


def back(cnt, sm):
    global ans

    if cnt >= n:
        total = 0
        for i in sm:
            if sm[i] >= m:
                total += 1
        ans = max(ans, total)
        return 

    for i in range(1, k+1):
        if sm[i] >= m:
            continue
            
        sm[i] = sm[i] + arr[cnt]
        back(cnt+1, sm)
        sm[i] = sm[i] - arr[cnt]

sm = {}
ans = 0
for i in range(1, k+1):
    sm[i] = 1 
back(0, sm)
print(ans)