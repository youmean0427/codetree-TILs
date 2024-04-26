N, G = map(int, input().split())
invite = set()
y = []
for _ in range(G):
    x = list(map(int, input().split()))
    y.append(x)
y.sort()

for c in range(2):
    for i in range(G):
        x = y[i]
        gp = x[0]

        cnt = 0
        temp = []
        for i in x[1:]:
            if i == 1:
                invite.add(i)
                cnt += 1
            elif i in invite:
                cnt += 1
            else:
                temp.append(i)
        
        if cnt == gp - 1:
            invite.add(temp[0])

        # print(x, invite, temp)        
print(len(invite))