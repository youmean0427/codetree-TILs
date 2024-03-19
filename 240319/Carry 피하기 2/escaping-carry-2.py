import sys
from collections import deque
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

arr = deque([])
n = int(input())
for _ in range(n):
    arr.append(int(input()))

ans = -1
def check(x, y):
    cnt = str(max(x, y))
    idx = 0
    while idx < len(cnt):
        xx = x % 10
        yy = y % 10
        x //= 10
        y //= 10
        if xx + yy >= 10:
            return False
        idx += 1
    return True

def dfs(idx, sm, cnt):
    global ans
    if idx >= n:
        if cnt == 3:
            if check(sm[0], sm[1]):
                if check(sm[0]+sm[1], sm[2]):
                    ans = max(sum(sm), ans)
        return

    dfs(idx+1, sm+[arr[idx]], cnt+1)
    dfs(idx+1, sm, cnt)

dfs(0, [], 0)
print(ans)