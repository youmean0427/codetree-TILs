import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
ans = float('inf')
for i in range(n):
    total = 0
    for j in range(n):
        total += abs(i-j) * arr[j]
    ans = min(total, ans)
print(ans)