from collections import defaultdict

n = int(input())
arr = list(map(int, input().split()))

i = 0
j = 1
dic = defaultdict(int)
dic[arr[i]] += 1
ans = 0

while (i <= j and i < n):
    
    if (j < n):
        if (dic[arr[j]] != 0):
            dic[arr[i]] -= 1
            i += 1
            continue
        else:
            dic[arr[j]] += 1
            ans = max(ans, j - i + 1)
            j += 1
            continue

    dic[arr[i]] -= 1
    i += 1
    
print(ans)