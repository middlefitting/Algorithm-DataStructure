N = int(input())
temp = 0
ind = 1
answer = 0
while True:
    N -= ind
    answer += 1
    if N == 0:
        print(answer)
        break
    ind += 1
    if ind > N:
        ind = 1

