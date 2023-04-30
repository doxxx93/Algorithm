n = int(input())
split = input().split()
past = int(split[0])
start = past
sol = 0

for i in range(n-1):
    curr = int(split[i+1])
    if curr <= past:
        sol = max(sol, past-start)
        start = curr
    past = curr

sol = max(sol, past-start)
print(sol)