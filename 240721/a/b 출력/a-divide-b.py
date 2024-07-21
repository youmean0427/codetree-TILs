a, b = map(int, input().split())

ans = ""
i = 0
res = ""

if a > b:
    res += str(a // b)
    a = a % b
    res += "."
else:
    a *= 10
    res += "0."

cnt = 0
while(len(ans) < 20):

    if i > 50:
        break

    if a == 0:
        ans += "0"
    elif a > b:
        if cnt > 1:
            while (cnt > 1):
                ans += "0"
                cnt -= 1
        ans += str(a//b)
        a = a % b
        cnt = 0
    else:
        a *= 10
        cnt += 1
    
    i += 1

print(res + ans)