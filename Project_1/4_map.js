// Custom Map
Array.prototype.myMap = function(callback){
    let res = [];

    for(let i = 0; i < this.length; i++){
        let val = this[i];
        let rv = callback(val, i, this);
        res.push(rv);
    }

    return res;
}
let arr = [
    {
        gender: 'M',
        age: 24
    },
    {
        gender: 'F',
        age: 34
    },
    {
        gender: 'F',
        age: 28
    },
    {
        gender: 'M',
        age: 74
    },
    {
        gender: 'F',
        age: 31
    },
    {
        gender: 'M',
        age: 47
    },
    {
        gender: 'F',
        age: 26
    },
    {
        gender: 'M',
        age: 47
    },
    {
        gender: 'F',
        age: 47
    },
    {
        gender: 'F',
        age: 19
    },
    {
        gender: 'M',
        age: 20
    }
];

let res=arr.myMap((v,i,oarr)=>v['gender']=='F' && v['age'] >=20 && v['age'] <=20   );
console.log(res);