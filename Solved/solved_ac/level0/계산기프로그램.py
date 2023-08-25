answer = int(input())
while True:
    n = str(input())
    if n == "=":
        break
    if n == "+":
        answer += int(input())
    if n == "-":
        answer -= int(input())
    if n == "/":
        answer //= int(input())
    if n == "*":
        answer *= int(input())
print(answer)