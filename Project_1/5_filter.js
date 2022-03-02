// Custom filter
Array.prototype.myfilter=function(cb){
    let oarr=this;
    let res=[];
    for(let i=0;i<oarr.length;i++){
        let v=oarr[i];
        let rbv=cb(v,i,this);
        if(rbv == true){
            res.push(v);
        }

    }
    return res;
}
arr=[10,20,30,40,15,17]
let res=arr.myfilter((v,i,oarr)=>v%2!=0);
console.log(res);
