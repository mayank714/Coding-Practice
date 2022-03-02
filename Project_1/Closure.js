function outer(){
    console.log("Hello I am outer");
    return function inner(){
        console.log("I Am inner");
    }
}
let rval=outer();
// console.log(rval);
rval();