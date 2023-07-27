use std::io;

fn get_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    input
}

fn main() {
    let n: i32 = get_input().trim().parse().expect("Type a number");
    let mut sum: i32 = 2;
    for i in 2..n + 1 {
        sum += (i / 2) + 1;
    }
    println!("{}", sum);
}