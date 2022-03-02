// 10_ArrarFlat.js
// ES2019 introduced the Array.prototype.flat() method that creates a new array with all the
//  elements of the subarrays concatenated to it recursively up to a specified depth.

// The depth parameter specifies how deep the method flats the array structure.
//  It defaults to 1.
// let newArray = arrayObject.flat([depth])

let arr=[10,20,[50,60,[90,100]],30,[70,[110,120],80],40];
let res1=arr.flat(1);
console.log(res1);
let res2=arr.flat(2);
console.log(res2);