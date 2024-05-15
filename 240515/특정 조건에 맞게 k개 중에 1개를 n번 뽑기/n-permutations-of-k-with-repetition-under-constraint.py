K, N = map(int, input().split())

def back(cnt, sm):
    
    if cnt >= N:
        print(*sm)
        return

    for i in range(1, K+1):
        if len(sm) >= 2:
            if i == sm[-1] == sm[-2]:
                continue
        back(cnt+1, sm+[i])
    
back(0, [])