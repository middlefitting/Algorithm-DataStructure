from itertools import combinations

dictionary = dict()


def solution(orders, course):
    for temp in orders:
        arr = list(temp)
        arr.sort()
        for n in range(len(arr)-1):
            for com in combinations(arr, len(arr) - n):
                key = ""
                for i in com:
                    key += i
                try:
                    dictionary[key] += 1
                except:
                    dictionary[key] = 1
    answer = []
    for i in course:
        mx = 2
        for key in dictionary.keys():
            if len(key) == i:
                if dictionary[key] >= mx:
                    mx = dictionary[key]
        for key in dictionary.keys():
            if len(key) == i:
                if dictionary[key] == mx:
                    answer.append(key)
    answer.sort()
    return answer


orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2,3,4]
print(solution(orders, course))