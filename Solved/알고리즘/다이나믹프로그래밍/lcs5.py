if __name__ == "__main__":
    s1 = str(input())
    s2 = str(input())

    dp = [0] * len(s1)

    for i_s2, c1 in enumerate(s2):
        tmp = 0
        for i_s1, c2 in enumerate(s1):
            if tmp < dp[i_s1]:
                tmp = dp[i_s1]
            elif c2 == c1:
                dp[i_s1] = tmp + 1
    print(max(dp))
