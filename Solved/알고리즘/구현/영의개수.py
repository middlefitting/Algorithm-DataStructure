for _ in range(int(input())):
    a, b = map(int, input().split())
    answer = 0
    for st in range(a, b + 1):
        for s in str(st):
            if s == "0":
                answer += 1
    print(answer)