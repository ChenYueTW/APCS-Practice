#include <iostream>
using namespace std;

int main() {
    int a, b, n, total = 0;
    cin >> a >> b >> n;

    for (int i = 0; i < n; i++) {
        int seconds;
        cin >> seconds;
        int second = seconds % (a + b);

        if (second > a) total += a + b - second;
        else if (second == a) total += b;
    }

    cout << total;
    return 0;
}