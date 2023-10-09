MIN = 1


def get_case_arr(temp):
    result = []
    for i in range(MIN, len(temp) + 1):
        result.append(temp[0:i])
    return result


def solution(phone_book):
    word = dict()
    phone_book.sort(key=len)
    global MIN
    MIN = len(phone_book[0])
    for temp in phone_book:
        case_arr = get_case_arr(temp)
        for c in case_arr:
            try:
                word[c] += 1
                return False
            except:
                continue
        word[temp] = 1
    return True


if __name__ == "__main__":
    test = ["01", "014",  "9"]
    print(solution(test))
