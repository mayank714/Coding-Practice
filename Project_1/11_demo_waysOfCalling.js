// 11_demo_waysOfCalling.js
let obj={
    fun1:function(frnd1,frnd2){
        console.log(this.fullname+" is his name "+this.age +" is his/her age");
        console.log(this.fullname+" is calling "+frnd1);
        console.log(this.fullname+" is calling "+frnd2);
        console.log(arguments);
    },
    fullname: "Mayank Verma",
    age: 23
};
let o2={
    fullname: "Shruti Verma",
age: 24
};
obj.fun1("Rahul","Vinay","Vicky","Vikas");
obj.fun1.call(o2,"Rahul","Vinay","Vicky","Vikas");
