def solution(clothes):
    answer = 1
    d = dict()
    for i in clothes:
        try:
            d[i[1]] += 1
        except:
            d[i[1]] = 1
    arr = []
    for key, value in d.items():
        arr.append(value)
    for i in arr:
        answer *= (i + 1)
    return answer - 1

if __name__ == "__main__":
    t = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
    print(solution(t))