a, b, c = map(int, input().split())

res = "NO"
for i in range(a, b+1):
    if i % c == 0:
        res = "YES"
        break
print(res)