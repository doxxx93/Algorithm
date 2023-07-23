use std::io;

fn parse_time(input: &str) -> i32 {
    let mut time = input.trim().split(":");
    time.next().unwrap().parse::<i32>().unwrap() * 3600 +
        time.next().unwrap().parse::<i32>().unwrap() * 60 +
        time.next().unwrap().parse::<i32>().unwrap()
}

fn get_input() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    input
}

fn main() {
    let input = get_input();
    let now = parse_time(&input);

    let another_input = get_input();
    let another_hour = parse_time(&another_input);

    if now < another_hour {
        println!("{:02}:{:02}:{:02}", (another_hour - now) / 3600 , (another_hour - now) % 3600 / 60, (another_hour - now) % 60);
    } else {
        println!("{:02}:{:02}:{:02}", (86400 - now + another_hour) / 3600 , (86400 - now + another_hour) % 3600 / 60, (86400 - now + another_hour) % 60);
    }
}