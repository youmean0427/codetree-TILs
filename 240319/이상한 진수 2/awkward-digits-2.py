import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

s = list(map(int, input()))

for i in range(len(s)):
    if s[i] == 0:
        s[i] = 1
        break

def two_to_ten(arr):
    idx = len(arr)-1
    two = 1
    result = 0
    while idx >= 0:
        result += two * arr[idx]
        idx -= 1
        two *= 2
    return result

ans = two_to_ten(s)
print(ans)