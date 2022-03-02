// custom Every for array
Array.prototype.myEvery=function(cb){
    for(let i=0;i<this.length;i++){
        let v=this[i];
        let rsv=cb(v,i,this);
        if(rsv==false){
            return false;
        }
       
    }
    return true;
}
let arr=[1,2,3,4,5];
let res=arr.myEvery((v,i,oarr)=>v % 2 ==0);
console.log(res);