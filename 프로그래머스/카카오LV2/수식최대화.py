# 100-200*300-500+20
answer = [0]
opers = [
    ["*", "-", "+"],
    ["*", "+", "-"],
    ["+", "-", "*"],
    ["+", "*", "-"],
    ["-", "*", "+"],
    ["-", "+", "*"]
]
def left(line):
    num = ""
    temp = line
    for i in range(len(line)):
        if line[len(line) - i - 1] in ["*", "-", "+"]:
            break
        else:
            num = line[-1 * (i + 1):]
            temp = line[:-1 * (i + 1)]
    return [num, temp]


def right(line):
    num = ""
    temp = line
    for i in range(len(line)):
        if line[i] in ["*", "-", "+"]:
            break
        else:
            num = line[:i + 1]
            temp = line[i + 1:]
    return [num, temp]

def f_oper(oper, left, right):
    left = left.replace("@", "-")
    right = right.replace("@", "-")

    if oper == "*":
        result = int(left) * int(right)
    if oper == "-":
        result = int(left) - int(right)
    if oper == "+":
        result = int(left) + int(right)

    if result < 0:
        result = str(result)
        return result.replace("-", "@")
    return result;


def transfer(oper, line):
    while oper in line:
        for i in range(len(line)):
            if line[i] == oper:
                left_num, left_line = left(line[:i])
                right_num, right_line = right(line[i + 1:])
                num = f_oper(oper, left_num, right_num)
                line = left_line + str(num) + right_line
                break
    return line


def solution(expression):
    for i in opers:
        line = expression
        for oper in i:
            line = transfer(oper, line)
        answer[0] = max(abs(int(line.replace("@", "-"))), answer[0])
    return answer[0]

print(solution("100-200*300-500+20"))
