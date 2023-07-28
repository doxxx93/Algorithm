use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n: i64 = input.trim().parse::<i64>().unwrap() % 45678;
    println!("{}", ((n + 1) * n / 2 * 5 - n.pow(2) + 1) % 45678);
}