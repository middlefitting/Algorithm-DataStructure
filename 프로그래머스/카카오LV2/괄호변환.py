from collections import deque


def good(u):
    queue = deque([])
    for i in u:
        if i == "(":
            queue.append("(")
        else:
            try:
                queue.popleft()
            except:
                return False
    return True


def rev(mid):
    result = ""
    for i in mid:
        if i == "(":
            result += ")"
        else:
            result += "("
    return result


def solution(p):
    answer = ""
    ctx = 0
    for i in range(len(p)):
        if p[i] == "(":
           ctx += 1
        else:
           ctx -= 1
        if ctx == 0:
            u = p[:i + 1]
            v = p[i + 1:]
            if good(u):
                answer = u + solution(v)
                return answer
            else:
                front = "("
                end = ")"
                mid = rev(u[1:-1])
                return front + solution(v) + end + mid
    return answer






# "()()))((()"

print(solution("()))((()"))
# print(solution("))()))((((") == "()()((()))")
# print(solution("))()))(((("))

# print(solution("(()())()") == "(()())()")
# print(solution("(()())()"))
