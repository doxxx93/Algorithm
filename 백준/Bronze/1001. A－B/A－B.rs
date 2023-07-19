use std::io;

fn main() {
    // read input
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut input = input.trim().split_whitespace();
    let a = input.next().unwrap().parse::<i32>().unwrap();
    let b = input.next().unwrap().parse::<i32>().unwrap();
    
    println!("{}", a - b)
}