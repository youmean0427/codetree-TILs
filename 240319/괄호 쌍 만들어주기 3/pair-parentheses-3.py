import sys
# sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

s = list(input())
ans = 0
for i in range(len(s)):

    if s[i] == '(':
        for j in range(i, len(s)):
            if s[j] == ')':
                ans += 1

print(ans)