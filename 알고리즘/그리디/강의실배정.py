import sys
import heapq

N = int(sys.stdin.readline())
arr = []

for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

# arr.sort(key=lambda x: x[0])
arr = sorted(arr, key=lambda x: x[0])


studyRoom = [0]
for i in range(N):
    if studyRoom[0] <= arr[i][0]:
        heapq.heappop(studyRoom)
    heapq.heappush(studyRoom,arr[i][1])
    print(studyRoom)
print(len(studyRoom))

