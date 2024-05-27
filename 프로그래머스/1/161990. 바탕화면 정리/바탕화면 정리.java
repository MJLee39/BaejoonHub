class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int min_x = wallpaper.length;
        int min_y = wallpaper[0].length();
        int max_x = -1;
        int max_y = -1;
        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].indexOf("#")!=-1){
                if(min_x>i){
                    min_x = i;
                }
                if(min_y>wallpaper[i].indexOf("#")){
                    min_y = wallpaper[i].indexOf("#");
                }
                if(max_x<i+1){
                    max_x=i+1;
                }
                if(max_y<wallpaper[i].lastIndexOf("#")+1){
                    max_y=wallpaper[i].lastIndexOf("#")+1;
                }
            }
            
        }
        // System.out.print("min_x: "+min_x);
        // System.out.print(", min_y: "+min_y);
        // System.out.print(", max_x: "+max_x);
        // System.out.print(", max_y: "+max_y);
        
        answer[0] = min_x;
        answer[1] = min_y;
        answer[2] = max_x;
        answer[3] = max_y;
        
        return answer;
    }
}