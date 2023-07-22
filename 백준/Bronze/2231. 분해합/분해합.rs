use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n: i32 = input.trim().parse().unwrap();
    for i in 0..n {
        let mut temp: i32 = i;
        let mut sum: i32 = i;
        while temp > 0 {
            sum += temp % 10;
            temp /= 10;
        };
        if sum == n {
            println!("{}", i);
            return;
        };
    }
    println!("0");
}