use std::io;

fn main() {
    // map number, count
    let mut map: Vec<(i32, i32)> = Vec::new();
    for _i in 0..10 {
        let mut input = String::new();
        io::stdin().read_line(&mut input).unwrap();
        let input: i32 = input.trim().parse().unwrap();
        let mut found = false;
        for j in 0..map.len() {
            if map[j].0 == input {
                map[j].1 += 1;
                found = true;
                break;
            }
        }
        if !found {
            map.push((input, 1));
        }
    }

    // average and mode
    let mut sum = 0;
    let mut mode = 0;
    let mut max = 0;
    for i in 0..map.len() {
        sum += map[i].0 * map[i].1;
        if map[i].1 > max {
            max = map[i].1;
            mode = map[i].0;
        }
    }

    let average = sum / 10;

    println!("{}", average);
    println!("{}", mode);
}