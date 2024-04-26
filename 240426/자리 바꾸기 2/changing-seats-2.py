n, k  = map(int, input().split())
arr = [i for i in range(1, n+1)]

cnt = {}
for i in range(n):
    cnt[arr[i]] = {i}
    
change = []

for _ in range(k):
    a, b = map(int, input().split())
    change.append((a, b))

count = 0
while count < 3*k:
    idx = count % k
    a = change[idx][0]
    b = change[idx][1]

    cnt[arr[a-1]].add(b-1)
    cnt[arr[b-1]].add(a-1)
  
    arr[a-1], arr[b-1] = arr[b-1], arr[a-1]
    count += 1

res = sorted(cnt.items(), key= lambda x: x[0])

for i in res:
    print(len(i[1]))