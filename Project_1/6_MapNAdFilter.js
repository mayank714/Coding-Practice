let product=[{name:"T-Shirt",price:25},
{name:"HeadPhones",price:125},
{name:"Keyboard",price:75},
{name:"Monitor",price:200}];
// console.log(product);
let res=product.map((v,i,oarr)=>v.price >=100);

console.log(product);
//  Sir We will always get the array of boolean in Map, then how we are getting the value in lower case and upper case in Map.
