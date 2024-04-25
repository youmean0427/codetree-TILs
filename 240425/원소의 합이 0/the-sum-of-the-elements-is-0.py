n = int(input())
nums = {}
for i in range(4):
    nums[i] = list(map(int, input().split()))
ans = 0
count = {}
for i in nums[0]:
    for j in nums[1]:
        for k in nums[2]:
            diff = -(i + j + k)

            if diff in nums[3]:
                ans += 1
    
    if i in count:
        count[i] += 1
    else:
        count[i] = 1

print(ans)