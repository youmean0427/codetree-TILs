S = input()
cnt = {}

for i in S:
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1

res = sorted(cnt.items(), key=lambda x: (x[1]))

if res[0][1] == 1:
    print(res[0][0])
else:
    print(None)