#include <iostream>
using namespace std;

int moves[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // Up Left down right
int map[100][100];

int turnRight(int movement);

int main() {
    int m = 0, n = 0, k, r, c;
    cin >> m >> n >> k >> r >> c;
    int x = r, y = c, movement = 3, total = 0, ans = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }

    while (map[x][y] != 0)
    {
        // Get score
        ans += 1;
        total += map[x][y];
        map[x][y] -= 1;

        // Detect k
        if (total % k == 0) {
            movement = turnRight(movement);
        }
        
        // Detect next step
        while (true)
        {
            int nextX = x + moves[movement][0];
            int nextY = y + moves[movement][1];

            if (nextX >= m || nextX < 0 || nextY >= n || nextY < 0) { // out field
                movement = turnRight(movement);
                continue;
            } else if (map[nextX][nextY] == -1) { // wall
                movement = turnRight(movement);
                continue;
            }
            break;
        }

        x += moves[movement][0];
        y += moves[movement][1];

        if (map[x][y] == 0) break;
    }
    
    cout << ans;
    return 0;
}

int turnRight(int movement) {
    return movement == 0 ? 3 : movement - 1;
}