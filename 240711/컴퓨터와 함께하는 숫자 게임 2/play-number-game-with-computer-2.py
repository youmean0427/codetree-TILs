m = int(input())
a, b = map(int, input().split())

def binary_sort(target):
    
    start = 1
    end = m
    cnt = 0
    while start <= end:
        
        mid = (start + end) // 2
        cnt += 1
        if mid == target:
            return cnt
        elif mid > target:
            end = mid - 1
        else:
            start = mid + 1

    return cnt


min_ans = float('inf')
max_ans = 0
for i in range(a, b+1):
    x = binary_sort(i)

    min_ans = min(min_ans, x)
    max_ans = max(max_ans, x)

print(min_ans, max_ans)