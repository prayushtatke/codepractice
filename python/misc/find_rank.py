from collections import Counter, OrderedDict


class LeagueTable:
    """
    The LeagueTable class tracks the score of each player in a league.
    After each game, the player records their score with the record_result function.
    The player's rank in the league is calculated using the following logic:
    1. The player with the highest score is ranked first (rank 1). The player with the lowest score is ranked last.
    2. If two players are tied on score, then the player who has played the fewest games is ranked higher.
    3. If two players are tied on score and number of games played,
        then the player who was first in the list of players is ranked higher.

    Implement the player_rank function that returns the player at the given rank.
    """
    def __init__(self, players):
        self.standings = OrderedDict([(player, Counter()) for player in players])

    def record_result(self, player, score):
        self.standings[player]['games_played'] += 1
        self.standings[player]['score'] += score

    # def player_rank(self, rank):
    #     return None

    # def __init__(self, players):
    #     self.standings = OrderedDict([(player, i) for i, player in enumerate(players)])
    #     self.scores = Counter()
    #     self.games_played = Counter()
    #     self.rankings = []
    #
    # def record_result(self, player, score):
    #     self.games_played[player] += 1
    #     self.scores[player] += score

    # def __process_rankings(self):

    def player_rank(self, rank):
        srt = sorted(self.standings.items(),
            key=lambda kv: ( -kv[1]['score'], kv[1]['games_played']), reverse=False)

        return srt[rank - 1][0]


table = LeagueTable(['Mike', 'Chris', 'Arnold'])
table.record_result('Mike', 2)
table.record_result('Mike', 3)
table.record_result('Arnold', 2)
table.record_result('Arnold', 5)
table.record_result('Chris', 5)

print(table.player_rank(1)) # should be Chris
print(table.player_rank(2)) # should be Arnold
print(table.player_rank(3)) # should be Mike

# print(table.standings)
# print(table.scores.most_common(1))
# print(table.games_played)
