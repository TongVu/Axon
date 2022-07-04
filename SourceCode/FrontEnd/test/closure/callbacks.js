const greeting = (name) => {
  console.log("Hello " + name);
};

const processUserName = (callback) => {
  name = "Axon Active";
  callback(name);
};

processUserName(greeting);
