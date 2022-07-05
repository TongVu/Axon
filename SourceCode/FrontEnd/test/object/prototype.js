// const cityObj = {
//   cityName: "Ho Chi Minh",

//   greet: function () {
//     console.log(`Welcome to ${this.cityName} city`);
//   },
// };

// cityObj.greet();
// console.log(cityObj); // we gonna see a bunch of different properties beside cityName and the greet() inside the object
// // what are these extra properties and where do they come from?
// console.log(cityObj.toString());
/**
 *
 *
 *
 *
 *
 */

// => Every object in JS has a built-in property, which is called prototype
// a prototype is an object, and it has its own prototype => making what's called a prototype chain, the chain ends when we reach a protptype that has null for its own prototype

/** SHADOWING PROPERTIES */
// define a property in an object, when a property with the same name
// is defined in the object's prototype
// const myDate = new Date(1995, 04, 24);
// console.log(myDate.getFullYear());

// myDate.getFullYear = function () {
//   console.log(
//     `Trying to override the getFullYear property from prototype of myDate`
//   );
// };

// myDate.getFullYear(); // => shadowing is kinda override in Java
/**
 *
 *
 *
 *
 *
 */

/** SETTING A PROTOTYPE */
// Using Object.create
const personPrototype = {
  greet: function () {
    console.log(`Hello u mother 4-letter-word-ker`);
  },
};

const carl = Object.create(personPrototype);
carl.greet();

// Using a constructor
function Person(name) {
  this.name = name;
}

Person.prototype = personPrototype;
Person.prototype.constructor = Person;
/* 
Here we create personPrototype which has a greet() method
a Person() constructor function which initializles the name of the person to create
*/
const reuben = new Person("Reuben");
reuben.greet();

/**
 *
 *
 * Own properties
 * properties that are defined directly in the object, are called own properties.
 * we can check this by Object.hasOwn()
 */
console.log(
  `Does Reuben have its own name property? ${Object.hasOwn(reuben, "name")}`
);

console.log(
  `Does Reuben have its own greeting property? ${Object.hasOwn(
    reuben,
    "greet"
  )}`
);
