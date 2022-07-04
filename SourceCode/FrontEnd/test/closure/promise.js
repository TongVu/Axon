const promise = new Promise((resolve, reject) => {
  isNameExist = false;
  if (isNameExist) resolve("User name exist");
  else reject("Error: Name doesn't exist");
});

promise
  .then((resolve) => console.log(resolve))
  .catch((reject) => {
    console.log(reject);
  });
