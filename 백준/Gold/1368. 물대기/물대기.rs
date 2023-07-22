/*
#include <stdio.h>
#include <iostream>
#include <queue>
#define MAX 305
using namespace std;
#define CLEAR(t) memset(t, 0, sizeof(t))
typedef pair<int, int>PII;
typedef vector<PII> VPII;

int edge[MAX][MAX], seen[MAX];

int main() {
    FILE *fin = fopen("water.in", "r"), *fout = fopen("water.out", "w");
    int N; fscanf(fin, "%d", &N);
    priority_queue<PII, VPII, greater<PII> > q;

    for (i = 0; i < N; i++) {
        int d; fscanf(fin, "%d", &d);
        q.push(PII(d, i));
    }
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            fscanf(fin, "%d", &edge[i][j]);

    int res = 0;
    while(!q.empty()) {
        PII top = q.top(); q.pop();
        int d = top.first, v = top.second;
        if (!seen[v]) {
            seen[v] = true;
            res += d;
	    for (i = 0; i < N; i++)
                q.push(PII(edge[v][i], i));
        }
    }
    fprintf(fout, "%d\n", res);
    return 0;
}
 */

// convert to rust

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