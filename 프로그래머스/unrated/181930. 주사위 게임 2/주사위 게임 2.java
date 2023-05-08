class Solution {
    public int solution(int a, int b, int c) {
        if (a != b && b != c && c != a){
            return a + b + c;
        }
        
        if ((a==b & b != c) || (a==c && a != b) || (b==c && a != b)){
            return (a+b+c)* (a*a + b*b + c*c);
        }
        if(a==b && b==c ){
            return (a+b+c) * (a*a+b*b+c*c) * (a*a*a+b*b*b+c*c*c);
        }
        return 0;
    }
}