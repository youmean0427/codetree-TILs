n, m = map(int, input().split())
arr = list(map(int, input().split()))

i = 0
j = 1
sum_nums = arr[i]
ans = 0

while (i <= j and j < n):
    if (sum_nums == m):
        ans += 1
        sum_nums -= arr[i]
        i += 1
        sum_nums += arr[j]
        j += 1
           
    
    elif (sum_nums > m):
        sum_nums -= arr[i]
        i += 1
    else:
        sum_nums += arr[j]
        j += 1
    
if (sum_nums == m):
    ans += 1

print(ans)