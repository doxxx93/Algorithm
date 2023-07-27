use std::io;

fn main() {
    loop {
        let mut input = String::new();
        io::stdin().read_line(&mut input).expect("Failed to read line");
        if input.trim() == "0 0 0" {
            break;
        }
        let mut sides: Vec<i32> = input.split_whitespace().map(|s| s.parse().unwrap()).collect();
        sides.sort();
        if sides[2] >= sides[1] + sides[0] {
            println!("Invalid");
        } else if sides[2] == sides[1] && sides[1] == sides[0] {
            println!("Equilateral");
        } else if sides[2] == sides[1] || sides[1] == sides[0] {
            println!("Isosceles");
        } else {
            println!("Scalene");
        }
    }
}