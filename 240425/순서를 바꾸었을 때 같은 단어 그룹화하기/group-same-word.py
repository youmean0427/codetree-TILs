from collections import defaultdict

N = int(input())
total = defaultdict(int)
ans = 0
arr = []
for i in range(N):
    S = input()
    cnt = {}
    for s in S:
        if s in cnt:
            cnt[s] += 1
        else:
            cnt[s] = 1
    
    arr.append(cnt)

ans = 0
for i in range(N):
    cnt = 0
    for j in range(i, N):
        if arr[i] == arr[j]:
            cnt += 1
    ans = max(ans, cnt)
print(ans)