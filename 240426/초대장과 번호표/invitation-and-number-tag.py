N, G = map(int, input().split())
invite = set()
for _ in range(G):
    x = list(map(int, input().split()))
    cnt = 0
    temp = set()
    for i in range(1, len(x)):
        if cnt == len(x)-2:
            invite.add(x[i])
            break
        if x[i] == 1:
            invite.add(x[i])
            cnt += 1
        elif x[i] in invite:
            cnt += 1
        else:
            temp.add(x[i])

    if cnt == len(x)-2:
        for t in temp:
            invite.add(t)
        
print(len(invite))