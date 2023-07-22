use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    let sum: i32 = input.trim().chars()
        .map(|c| {
            if c.is_ascii_lowercase() {
                c as i32 - 'a' as i32 + 1
            } else {
                c as i32 - 'A' as i32 + 27
            }
        })
        .sum();

    if is_prime(sum) {
        println!("It is a prime word.");
    } else {
        println!("It is not a prime word.");
    }
}

fn is_prime(n: i32) -> bool {
    if n == 1 {
        return true;
    }

    let mut i = 2;
    while i * i <= n {
        if n % i == 0 {
            return false;
        }
        i += 1;
    }
    true
}