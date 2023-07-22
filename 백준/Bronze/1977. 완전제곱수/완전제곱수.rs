use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let m = input.trim().parse::<i32>().unwrap();
    input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n = input.trim().parse::<i32>().unwrap();
    // m이상 n이하의 완전 제곱수를 찾아서 합과 최솟값을 출력한다.
    let mut sum = 0;
    let mut min = n;
    for i in m..n+1 {
        let sqrt = (i as f64).sqrt() as i32;
        if sqrt * sqrt == i {
            sum += i;
            if min > i {
                min = i;
            }
        }
    }
    if sum == 0 {
        println!("-1");
    } else {
        println!("{}", sum);
        println!("{}", min);
    }
}