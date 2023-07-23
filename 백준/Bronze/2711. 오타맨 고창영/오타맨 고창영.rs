use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut n: i32 = input.trim().parse().unwrap();
    while n > 0 {
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        // number " " string
        let mut iter = input.split_whitespace();
        let number: i32 = iter.next().unwrap().parse().unwrap();
        let string: String = iter.next().unwrap().parse().unwrap();
        let mut result = String::new();
        // omit the number-th character
        for (i, c) in string.chars().enumerate() {
            if i != (number - 1) as usize {
                result.push(c);
            }
        }
        println!("{}", result);
        n -= 1;
    }
}