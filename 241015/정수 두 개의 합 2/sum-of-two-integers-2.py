n, k  = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr.sort()

i = 0
j = 1
nums_sum = arr[i] + arr[j]
ans = 0

while (i <= j and i < n):

    if (nums_sum <= k and j < n):
        ans += 1
        nums_sum -= arr[j]
        j += 1
        if (j < n):
            nums_sum += arr[j]
    else:
        nums_sum -= arr[i]
        if (j >= n):
            j -= 1
        nums_sum -= arr[j]
        i += 1
        j = i + 1
      
        if (i < n):
            nums_sum += arr[i]
        if (j < n):
            nums_sum += arr[j]

print(ans)