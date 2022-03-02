// Custom some
Array.prototype.mySome=function(cb){
    for(let i=0;i<this.length;i++){
        let v=this[i];
        let rsv=cb(v,i,this);
        if(rsv==true){
            return true;
        }
        
    }
    return false;
}
let arr=[1,2,3,4,5];
let res=arr.mySome((v,i,oarr)=>v % 2 ==0);
console.log(res);