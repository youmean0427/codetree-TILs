N, M = map(int, input().split())
a = []
b = []
for _ in range(N):
    a.append(list(input()))
for _ in range(N):
    b.append(list(input()))

def check(aa, bb):
    if len(aa & bb) > 0:
        return False
    return True

ans = 0
# 같은 위치(index)에서 A와 B의 알파벳들을 비교해야함
for i in range(M-2):
    for j in range(i+1, M-1):
        for l in range(j+1, M):
 
            sa = set()
            sb = set()

            for idx in range(3):
                sum_a = a[idx][i] + a[idx][j] + a[idx][l]
                sa.add(sum_a)

                sum_b = b[idx][i] + b[idx][j] + b[idx][l]
                sb.add(sum_b)

            if check(sa, sb):
                ans += 1
            
print(ans)