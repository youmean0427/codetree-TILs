from collections import deque

A = list(input())
q = deque(A)

ans = float('inf')
for i in range(len(A)):
    q.rotate(1)

    res = []
    temp = ''
    cnt = 0

    for idx in range(len(A)):
        if temp == q[idx]:
            cnt += 1
        else:
            res.append(temp)
            res.append(cnt)
            temp = q[idx]
            cnt = 1 
            
    res.append(temp)
    res.append(cnt)
    
    ans = min(ans, len(res)-2)

print(ans)