answer = [0]
def logic(arr, info, vec, lam, wol):
    for i in arr:
        is_lam = 0
        is_wol = 0
        if info[i] == 0:
            is_lam += 1
        else:
            is_wol += 1
        if lam + is_lam > wol + is_wol:
            answer[0] = max(answer[0], lam + is_lam)
            nex = arr.copy()
            for y in vec[i]:
                nex.append(y)
            nex.pop(arr.index(i))
            logic(nex, info, vec, lam + is_lam, wol + is_wol)


def solution(info, edges):
    vec = [[] for _ in range(len(info))]
    for a, b in edges:
        vec[a].append(b)
    arr = [0]
    logic(arr, info, vec, 0, 0)
    return answer[0]


print(solution([0,1,0,1,1,0,1,0,0,1,0], [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]))