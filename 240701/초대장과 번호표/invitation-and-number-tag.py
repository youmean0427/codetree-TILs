N, G = map(int, input().split())
y = []
for _ in range(G):
    x = list(map(int, input().split()))
    y.append(x)      


y.sort()

s = {1}
for cnt in range(G):
    for i in range(G):
        cnt = 0
        for j in range(1, len(y[i])):
            if y[i][j] in s:
                cnt += 1

        if cnt == len(y[i])-2:
            for j in range(1, len(y[i])):
                s.add(y[i][j])

print(len(s))