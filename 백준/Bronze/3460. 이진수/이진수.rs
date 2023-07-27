use std::io;

fn get_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    input
}

fn main() {
    let mut t: i32 = get_input().trim().parse().expect("Type a number");
    while t> 0 {
        let n: i32 = get_input().trim().parse().expect("Type a number");
        let mut temp: i32 = n;
        let mut index: i32 = 0;
        while temp > 0 {
            let digit: i32 = temp % 2;
            if digit ==1 {
                print!("{} ",index)
            }
            index += 1;
            temp /= 2;
        };
        println!();
        t -= 1;
    };
}