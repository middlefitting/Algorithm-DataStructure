for _ in range(int(input())):
    arr = list(map(int, input().split()))
    answer = []
    for i in arr:
        if not i % 2:
            answer.append(i)
    print(sum(answer), min(answer))

