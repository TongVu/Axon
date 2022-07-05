/*

// Object fundamental
const person = {
  name: ["Tong", "Vu"],
  age: 27,

  bio: function () {
    console.log(`${this.name[0]} ${this.name[1]} is ${this.age} years old`);
  },
  introduce: function () {
    console.log(`Hi, my name's ${this.name[0]} ${this.age}`);
  },
};


console.log(`Person name: ${person.name}`);
console.log(`Person bio: `);
person.bio();

console.log(`Person introduce: `);
person.introduce();
*/

// Constructor
function Person(name, age) {
  this.name = name;
  this.age = age;
}
const mother = {
  name: "Kelly Kerr",
  age: 24,
  child: new Person("John Kyle", 4),
  bio: function () {
    // console.log(
    //   `${this.name} has a ${this.child.age}-year-old child, his name is ${this.child.name}`
    // );
    console.log(
      `${this.name} has a son ${this.child.age}-year-old and his name is ${this.child.name}`
    );
  },
};
mother.bio();
