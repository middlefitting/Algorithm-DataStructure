def solution(numbers):
    strs = list(map(str, numbers))
    strs.sort(key=lambda x: x * 4, reverse=True)
    if strs[0] == '0':
        return '0'
    answer = ''.join(strs)
    return answer

print(solution([6, 10, 2, 11, 1]))
