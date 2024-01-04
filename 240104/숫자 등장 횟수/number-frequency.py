n, m = map(int, input().split())
cnt = {}
for i in input().split():
    if i in cnt:
        cnt[i] += 1
    else:
        cnt[i] = 1

result = [k for k in input().split()]
for k in result:
    if k in cnt:
        print(cnt[k], end = " ")
    else:
        print(0, end= " ")