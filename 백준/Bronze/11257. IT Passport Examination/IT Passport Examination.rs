use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut n: i32 = input.trim().parse().unwrap();
    while n > 0 {
        let mut line = String::new();
        io::stdin().read_line(&mut line).unwrap();
        let mut iter = line.trim().split_whitespace();
        let id = iter.next().unwrap();
        let a = iter.next().unwrap().parse::<f64>().unwrap();
        let b = iter.next().unwrap().parse::<f64>().unwrap();
        let c = iter.next().unwrap().parse::<f64>().unwrap();
        let sum = a + b + c;
        if sum >= 55f64 && a >= 35f64 * 0.3 && b >= 25f64 * 0.3 && c >= 40f64 * 0.3 {
            println!("{} {} PASS", id, sum);
        } else {
            println!("{} {} FAIL", id, sum);
        }
        n -= 1;
    }
}