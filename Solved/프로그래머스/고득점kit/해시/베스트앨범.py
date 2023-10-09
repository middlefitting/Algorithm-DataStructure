import heapq


def solution(genres, plays):
    answer = []
    genres_info = dict()
    play_info = dict()
    for i in range(len(genres)):
        try:
            genres_info[genres[i]] += plays[i]
            heapq.heappush(play_info[genres[i]], [-1 * plays[i], i])
        except KeyError:
            genres_info[genres[i]] = plays[i]
            play_info[genres[i]] = []
            heapq.heappush(play_info[genres[i]], [-1 * plays[i], i])

    heap = []
    for key, value in genres_info.items():
        heapq.heappush(heap, [-1 * value, key])
    while heap:
        ind = 0
        temp_genre = heapq.heappop(heap)[1]
        songs_list = play_info[temp_genre]
        while songs_list and ind < 2:
            ind += 1
            answer.append(heapq.heappop(songs_list)[1])
    return answer


if __name__ == "__main__":
    print(solution(["classic", "pop", "classic", "classic", "pop"],
                   [500, 600, 150, 800, 2500]))
