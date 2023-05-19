while True:
    answer = 0
    s = str(input())
    if s == "#":
        break
    for i in s:
        if i.upper() in ['A', 'E', 'I', 'O', 'U']:
            answer += 1
    print(answer)