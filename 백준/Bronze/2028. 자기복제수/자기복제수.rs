use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let t: i32 = input.trim().parse().unwrap();
    for _i in 0..t {
        input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let n:i32 = input.trim().parse().unwrap();
        if (n * n).to_string().ends_with(&n.to_string()) {
            println!("YES")
        } else {
            println!("NO")
        }
    }
}