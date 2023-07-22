use std::io;

fn main() {
    while true {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let mut n: i32 = input.trim().parse().unwrap();
        if n == 0 {
            break;
        };
        while n >= 10 {
            let mut sum: i32 = 0;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }

        println!("{}", n);
    }
}