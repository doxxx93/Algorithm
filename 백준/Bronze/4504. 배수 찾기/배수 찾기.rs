use std::io;

fn get_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input
}

fn main() {
    let mut input = get_input();
    let n = input.trim().parse::<i32>().unwrap();

    loop {
        input = get_input();
        let number = input.trim().parse::<i32>().unwrap();
        if number == 0 {
            break;
        }
        if number % n == 0 {
            println!("{} is a multiple of {}.", number, n);
        } else {
            println!("{} is NOT a multiple of {}.", number, n);
        }
    }
}