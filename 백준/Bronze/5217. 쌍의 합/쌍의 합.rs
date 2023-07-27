use std::io;


/*
#include <iostream>
#define ll long long
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        int cnt = 0;
        cin >> n;
        cout << "Pairs for " << n << ": ";
        for (int i = 1; i <= 12; i++)
            for (int j = 1; j <= 12; j++)
                if (i + j == n && i<j)
                {
                    if (!cnt)
                    {
                        cnt++;
                        cout << i << ' ' << j;
                    }
                    else
                        cout << ", " << i << ' ' << j;
                }
        cout << '\n';
    }
}

 */
fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let t: i32 = input.trim().parse().unwrap();
    for _k in 0..t {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let n: i32 = input.trim().parse().unwrap();
        let mut cnt: i32 = 0;
        print!("Pairs for {}: ", n);
        for i in 1..13 {
            for j in 1..13 {
                if i + j == n && i < j {
                    if cnt == 0 {
                        cnt += 1;
                        print!("{} {}", i, j);
                    } else {
                        print!(", {} {}", i, j);
                    }
                }
            }
        }
        println!();
    }
}