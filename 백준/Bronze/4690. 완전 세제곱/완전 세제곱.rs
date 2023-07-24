fn main() {
    for a in 2..=100 {
        for b in 2..a {
            for c  in 2..a  {
                for d in 2..a {
                    if b <= c && c <= d {
                        if a * a * a == b * b * b + c * c * c + d * d * d {
                            println!("Cube = {}, Triple = ({},{},{})", a, b, c, d);
                        }
                    }
                }
            }
        }
    }
}