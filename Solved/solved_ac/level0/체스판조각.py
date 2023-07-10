N = int(input())
if N == 1:
    print(2)
else:
    answer = 2
    ind = 1
    for i in range(N - 1):
        if i % 2 == 0:
            ind += 1
        answer += ind
    print(answer)
