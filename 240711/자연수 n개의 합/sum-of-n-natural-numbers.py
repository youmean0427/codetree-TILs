s = int(input())

left = 1
right = s

max_val = 0

while left <= right:
    mid = (left + right) // 2
    if (mid * (mid + 1)) // 2 <= s:
        left = mid + 1
        max_val = max(max_val, mid)
    else:
        right = mid - 1

print(max_val)