def calc(arr1, arr2):
    value = 0
    for i in range(len(arr1)):
        value += arr1[i] * arr2[i]
    return value


if __name__ == "__main__":
    good = [1, 2, 3, 3, 4, 10]
    evil = [1, 2, 2, 2, 3, 5, 10]
    for i in range(1, int(input()) + 1):
        t_good = list(map(int, input().split()))
        t_evil = list(map(int, input().split()))
        v_good = calc(good, t_good)
        v_evil = calc(evil, t_evil)
        if v_good == v_evil:
            print(f"Battle {i}: No victor on this battle field")
        elif v_good < v_evil:
            print(f"Battle {i}: Evil eradicates all trace of Good")
        else:
            print(f"Battle {i}: Good triumphs over Evil")
