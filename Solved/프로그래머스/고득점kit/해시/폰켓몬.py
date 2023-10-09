def solution(nums):
    max_answer = len(nums) // 2
    answer = 0
    d = dict()
    for i in nums:
        try:
            d[i] += 1
        except:
            d[i] = 1
            answer += 1
    answer = min(max_answer, answer)
    return answer