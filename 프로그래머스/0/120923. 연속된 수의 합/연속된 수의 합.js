function solution(num, total) {
    var answer = [];
    //total%num==0
    if(num%2==1){
        for(var i=0;i<num;i++){
            answer.push((total/num)-Math.floor(num/2)+i);
        }
    }else{
        for(var i=0;i<num;i++){
            answer.push((total/num)-0.5*(2*(num/2)-1)+i);
        }
    }
    return answer;
}