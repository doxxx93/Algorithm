use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n: i32 = input.trim().parse().unwrap();

    let mut fib = vec![0; n as usize + 1];
    fib[0] = 0;
    fib[1] = 1;
    for i in 2..n as usize + 1 {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    println!("{}", fib[n as usize]);
}