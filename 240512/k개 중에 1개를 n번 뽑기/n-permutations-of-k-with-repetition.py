K, N = map(int, input().split())

def back(n, sm):

    if n >= N:
        print(*sm)
        return
    
    for i in range(1, K+1):
        sm.append(i)
        back(n+1, sm)
        sm.pop()

back(0, [])