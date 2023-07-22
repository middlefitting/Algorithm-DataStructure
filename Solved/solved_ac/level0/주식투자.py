for _ in range(int(input())):
    answer = 0
    for __ in range(int(input())):
        answer += max(0, max(list(map(int, input().split()))))
    print(answer)
