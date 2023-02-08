import sys

parse = str(sys.stdin.readline())
answer = 0

if parse[0] == 'c':
    answer = 26
else:
    answer = 10

for i in range(1, len(parse)):
    if parse[i] == 'c':
        if parse[i - 1] == 'c':
            answer *= 25
        else:
            answer *= 26
    if parse[i] == 'd':
        if parse[i - 1] == 'd':
            answer *= 9
        else:
            answer *= 10

print(answer)
