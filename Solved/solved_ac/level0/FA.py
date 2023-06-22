N = str(input())
i = 0
while True:
    if int(N) == len(N) * int(N[0]):
        print("FA")
        break
    N = str(len(N) * int(N[0]))
    i += 1
    if i == 100000000:
        print("NFA")
        break
