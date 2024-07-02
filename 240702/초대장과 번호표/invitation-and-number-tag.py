N, G = map(int, input().split())
y = []
for _ in range(G):
    x = list(map(int, input().split()))
    y.append(set(x[1:]))  

q = []
for i in range(G):
    if 1 in y[i]:
        q.append(y[i])

total = set([1])

while q:
    
    s = q.pop(0)
    cnt = 0
    for i in s:
        if i in total:
            cnt += 1
    
    if cnt == len(s)-1:
        for i in s:
            total.add(i)
            for k in range(G):
                if i in y[k]:
                    q.append(y[k])

print(len(total))