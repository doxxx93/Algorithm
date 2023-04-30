line = input()
n = len(line)

a, b = 0, 0
for i in range(1, n//2+1):
    for j in range(i, n+1):
        if i * j == n:
            a, b = i, j

ans = ''
for i in range(a):
    for j in range(i, n, a):
        ans += line[j]

print(ans)