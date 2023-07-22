use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut n = input.trim().parse::<i32>().unwrap();
    while n > 0 {
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let mut iter = input.trim().split("-");
        let left = iter.next().unwrap();
        let right = iter.next().unwrap();
        let left_num = left.chars().fold(0, |acc, c| acc * 26 + (c as i32 - 'A' as i32));
        let right_num = right.chars().fold(0, |acc, c| acc * 10 + (c as i32 - '0' as i32));
        if (left_num - right_num).abs() <= 100 {
            println!("nice");
        } else {
            println!("not nice");
        }
        n -= 1;
    };
}