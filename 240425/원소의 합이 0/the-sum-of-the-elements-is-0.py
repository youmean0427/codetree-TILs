from collections import defaultdict
n = int(input())
nums = {}
for i in range(4):
    nums[i] = list(map(int, input().split()))

ans = 0
count = defaultdict(int)

for i in range(n):
    for j in range(n):
        sum_val = nums[0][i] + nums[1][j]
        count[sum_val] += 1

for i in range(n):
    for j in range(n):
        diff = -(nums[2][i] + nums[3][j])

        if diff in count:
            ans += count[diff]

print(ans)