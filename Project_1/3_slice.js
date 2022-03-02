let arr=[10,20,30,40];
for(let i=0;i<=arr.length;i++){
    for(let j=i+1;j<=arr.length;j++){
        console.log(arr.slice(i,j));
    }
}