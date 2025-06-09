a, b, c = map(int, input().split())

ans = "YES"
for i in range(a, b+1):
    if i % c == 0:
        ans = "NO"
        break

print(ans)