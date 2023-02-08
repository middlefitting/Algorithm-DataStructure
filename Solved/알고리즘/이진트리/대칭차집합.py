# 3 5
# 1 2 4
# 2 3 4 5 6

N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

dictionary = dict()
for i in A:
    dictionary[i] = 1

answer = 0
for i in B:
    if dictionary.get(i):
        answer += dictionary.get(i)

print(len(A) + len(B) - answer * 2)
