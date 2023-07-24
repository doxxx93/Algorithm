use std::io;

fn get_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    input
}

fn main() {
    loop {
        let input = get_input();
        if input.eq("0 0 0\n") {
            break;
        }
        let numbers = input.trim().split_whitespace().map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let a = numbers[0];
        let b = numbers[1];
        let c = numbers[2];

        // is ap or gp
        if b - a == c - b {
            let d = b - a;
            println!("AP {}", c + d);
        } else {
            let d = b / a;
            println!("GP {}", c * d);
        }
    }
}