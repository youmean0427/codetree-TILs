import sys
from collections import deque
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

n = int(input())
arr = deque([])
for _ in range(n):
    arr.append(int(input()))

ans = float('inf')
for i in range(n):
    total = 0
    arr.rotate(-i)
    for j in range(n):
        total += arr[j] * j
    ans = min(ans, total)
print(ans)