n, s = map(int, input().split())
arr = list(map(int, input().split()))

i = 0
j = 1
ans = arr[i]
l = float('inf')

while (1):

    if i >= n:
        break
    if j < n:
        if (ans >= s):
            l = min(l, j - i)
            i += 1
            ans -= arr[i]
            continue
    
    if (j < n):
        ans += arr[j]
        j += 1
    else:
        i += 1
        if (i >= n):
            break
        ans -= arr[i]
        
if l == float('inf'):
    l = -1

print(l)