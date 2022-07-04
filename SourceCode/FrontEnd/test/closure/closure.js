const first = () => {
  const greet = "hi";
  const second = () => {
    const name = "Tong";
    console.log(greet + " " + name);
  };
  return second;
};

const newFunc = first();
newFunc();
