use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut n: i32 = input.trim().parse().unwrap();
    while n > 0 {
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let number: i32 = input.trim().parse().unwrap();

        if number == 1{
            println!("#");
            println!();
            n -= 1;
            continue;
        }

        println!("{}", "#".repeat(number as usize));
        for _i in 1..number - 1 {
            println!("#{}#", "J".repeat((number - 2) as usize));
        }
        println!("{}", "#".repeat(number as usize));
        if n > 1 {
            println!();
        };
        n -= 1;
    }
}