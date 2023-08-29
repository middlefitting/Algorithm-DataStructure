for i in range(int(input())):
    leg_count, chicken_count = map(int, input().split())
    print((chicken_count * 2 - leg_count), chicken_count - (chicken_count * 2 - leg_count))
