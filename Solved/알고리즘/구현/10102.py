N = int(input())
s = str(input())
A = 0
B = 0
for i in s:
    if i == "A":
        A += 1
    else:
        B += 1
if A > B:
    print("A")
elif B > A:
    print("B")
else:
    print("Tie")
