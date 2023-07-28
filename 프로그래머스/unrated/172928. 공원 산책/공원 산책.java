import java.util.*;

class Solution {
    public Object solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        
        int sX = 0;
        int sY = 0;
        
        for(int x = 0; x < park.length; x++){
            for (int y = 0; y < park[x].length(); y++){
                if(park[x].charAt(y) == 'S'){
                    sX = x;
                    sY = y;
                }
            }
        }

        for(String route: routes){
            char op = route.charAt(0);
            int n = route.charAt(2) -'0';
            // 범위 체크
            if (op == 'N'){
                if ( sX - n < 0 ){
                    continue;
                }
                boolean block = false;
                for (int i = sX - n; i <=sX; i++){
                    if (park[i].charAt(sY) == 'X'){
                        block = true;
                    }
                }
                if(block) {
                    continue;
                }
                sX -= n;
            } else if ( op == 'S'){
                if ( sX + n >= h){
                    continue;
                }
                boolean block = false;
                for (int i = sX; i <=sX + n; i++){
                    if (park[i].charAt(sY) == 'X'){
                    block = true;
                    }
                }
                if(block) {
                    continue;
                }
                sX += n;
            } else if ( op == 'E'){
                if( sY + n >= w ){
                    continue;
                }
                boolean block = false;
                for(int i = sY; i <= sY+n; i++){
                    if(park[sX].charAt(i)=='X'){
                        block = true;
                    }
                }
                if (block) {
                    continue;
                }
                sY += n;
            } else {
                if (sY - n < 0){
                    continue;
                }
                boolean block = false;
                for(int i = sY-n; i < sY; i++){
                    if(park[sX].charAt(i)=='X'){
                        block = true;
                    }
                }
                if (block) {
                    continue;
                }
                sY -= n;
            }
            System.out.println(sX+ " " + sY);
        }
        return new int[]{sX,sY};
    }
}