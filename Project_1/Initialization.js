// var 
var a=10;
function fn(){
    console.log(a);
    var a;
    console.log(a);
a=20;
console.log(a);


}
fn();