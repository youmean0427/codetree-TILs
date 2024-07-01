n, m = map(int, input().split())

na = set(map(int, input().split()))
mb = set(map(int, input().split()))

x = na - mb
y = mb - na

print(len(x | y))