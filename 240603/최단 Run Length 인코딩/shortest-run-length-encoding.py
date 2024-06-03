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
            res.append(str(cnt))
            temp = q[idx]
            cnt = 1 

    res.append(temp)
    res.append(str(cnt))
    res_str = ""
    for res_idx in range(2, len(res)):
         res_str += res[res_idx]

    ans = min(ans, len(res_str))

print(ans)