use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut input = input.trim().split_whitespace();
    let a: f64 = input.next().unwrap().parse().unwrap();
    let b: f64 = input.next().unwrap().parse().unwrap();
    println!("{}", a / b);
}