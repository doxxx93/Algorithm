use std::io::{self, BufRead};
use std::cmp::Ordering;
use std::collections::BinaryHeap;

#[derive(Copy, Clone, Eq, PartialEq)]
struct PII {
    first: i32,
    second: i32,
}

impl Ord for PII {
    fn cmp(&self, other: &Self) -> Ordering {
        other.first.cmp(&self.first)
    }
}

impl PartialOrd for PII {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let n: i32 = lines.next().unwrap().unwrap().parse().unwrap();
    let mut edge: Vec<Vec<i32>> = vec![vec![0; n as usize]; n as usize];
    let mut seen: Vec<bool> = vec![false; n as usize];
    let mut q: BinaryHeap<PII> = BinaryHeap::new();

    for i in 0..n {
        let d: i32 = lines.next().unwrap().unwrap().parse().unwrap();
        q.push(PII { first: d, second: i });
    }
    for i in 0..n {
        let mut line = lines.next().unwrap().unwrap();
        line.push(' ');
        let mut j = 0;
        let mut num = String::new();
        for c in line.chars() {
            if c == ' ' {
                edge[i as usize][j] = num.parse().unwrap();
                j += 1;
                num = String::new();
            } else {
                num.push(c);
            }
        }
    }

    let mut res = 0;
    while !q.is_empty() {
        let top = q.pop().unwrap();
        let d = top.first;
        let v = top.second;
        if !seen[v as usize] {
            seen[v as usize] = true;
            res += d;
            for i in 0..n {
                q.push(PII { first: edge[v as usize][i as usize], second: i });
            }
        }
    }
    println!("{}", res);
}