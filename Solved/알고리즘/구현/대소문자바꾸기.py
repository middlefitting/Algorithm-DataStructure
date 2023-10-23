s = str(input())
answer = ""
a = ord("a")
z = ord("z")
A = ord("A")
Z = ord("Z")
for i in s:
    if a <= ord(i) <= z:
        answer += chr(ord(i) - 32)
    elif A <= ord(i) <= Z:
        answer += chr(ord(i) + 32)
    else:
        answer += i
print(answer)
