from collections import defaultdict
n = int(input())
nums = {}
for i in range(4):
    nums[i] = list(map(int, input().split()))
ans = 0
count = defaultdict(int)
for i in nums[3]:
    count[i] += 1

for i in nums[0]:
    for j in nums[1]:
        for k in nums[2]:
            diff = -(i + j + k)

            if diff in count:
                ans += count[diff]

print(ans)