from collections import defaultdict

n, k = map(int, input().split())
arr = list(map(int, input().split()))

count = defaultdict(int)

for i in arr:
    count[i] += 1

count_list = list(count.items())
count_list.sort(key=lambda x: (-x[1], -x[0]) )

for i in range(k):
    print(count_list[i][0], end=" ")