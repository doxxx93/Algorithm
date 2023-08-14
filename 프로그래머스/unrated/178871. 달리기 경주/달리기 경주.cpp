#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    unordered_map<string, vector<string>::iterator> player_positions;

    // Record the initial positions of the players
    for(auto i = players.begin(); i != players.end(); ++i){
        player_positions[*i] = i;
    }

    for(const auto &calling : callings){
        auto it = player_positions[calling];

        // Skip if calling is the first player
        if(it == players.begin())
            continue;

        // Swap positions with player in front
        iter_swap(it, it - 1);

        // Update player_positions map
        swap(player_positions[*it], player_positions[*(it - 1)]);
    }

    return players;
}