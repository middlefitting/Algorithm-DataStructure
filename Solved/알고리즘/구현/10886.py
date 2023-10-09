answer = 0
for i in range(int(input())):
    if int(input()) == 1:
        answer += 1
    else:
        answer -= 1
if answer > 0:
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")
