A = list(map(int, input().split()))
B = list(map(int, input().split()))
last = -1
score = [0, 0]
for i in range(10):
    if A[i] > B[i]:
        score[0] += 3
        last = 1
    elif B[i] > A[i]:
        score[1] += 3
        last = 2
    else:
        score[0] += 1
        score[1] += 1
print(score[0], score[1])
if score[0] > score[1]:
    print("A")
elif score[1] > score[0]:
    print("B")
else:
    if last == 1:
        print("A")
    elif last == 2:
        print("B")
    else:
        print("D")