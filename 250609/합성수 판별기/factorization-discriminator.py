n = int(input())

res = "N"
for i in range(2, n):
    if n % i == 0:
        res = "C"
        break

print(res)