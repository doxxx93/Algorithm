use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let mut line1 = [0; 26];
    let mut line2 = [0; 26];
    let mut sum = 0;
    for i in input.chars() {
        if i == '\n' {
            break;
        }
        line1[i as usize - 'a' as usize] += 1;
    }
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    for i in input.chars() {
        if i == '\n' {
            break;
        }
        line2[i as usize - 'a' as usize] += 1;
    }
    for i in 0..26 {
        sum += (line1[i] - line2[i] as isize).abs() as usize;
    }
    println!("{}", sum);
}



