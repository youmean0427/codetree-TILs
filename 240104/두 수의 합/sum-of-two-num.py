from collections import defaultdict
n, k = map(int, input().split())
arr = [int(i) for i in input().split()]

cnt = defaultdict(int)
ans = 0
for i in arr:
    t = k - i
    ans += cnt[t] 
    cnt[i] += 1    
    
print(ans)