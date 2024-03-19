import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

s = list(map(int, input().rstrip()))

def change_num (s):
    for i in range(len(s)):
        if s[i] == 0:
            s[i] = 1
            return s

    for i in range(len(s)-1, -1, -1):
        if s[i] == 1:
            s[i] = 0
            return s

def two_to_ten(arr):
    idx = len(arr)-1
    two = 1
    result = 0
    while idx >= 0:
        result += two * arr[idx]
        idx -= 1
        two *= 2
    return result

s = change_num(s)
ans = two_to_ten(s)
print(ans)