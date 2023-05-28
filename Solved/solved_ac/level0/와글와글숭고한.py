univ = ["Soongsil", "Korea", "Hanyang"]
arr = list(map(int, input().split()))
if sum(arr) >= 100:
    print("OK")
else:
    ind = arr.index(min(arr))
    print(univ[ind])
