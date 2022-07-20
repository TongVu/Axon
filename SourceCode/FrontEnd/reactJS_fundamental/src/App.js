import React, { useState } from "react";
import "./App.css";
import Form from "./Form";

function App() {
  const [todos, setTodos] = useState([
    "Learn Reactjs",
    "How to connect React and Spring Boot?",
    "Is React Hard to learn?",
  ]);
  const [isOn, setIsOn] = useState(true);

  function handleClick(e) {
    const inputTodo = document.querySelector("#input_todo");

    if (!inputTodo.value === "" || !todos.includes(inputTodo.value))
      setTodos([...todos, inputTodo.value]);

    inputTodo.value = "";
  }

  /** THIS PART IS USE FOR CONDITIONAL RENDERING */
  let buttonOnOff;
  if (isOn)
    buttonOnOff = (
      <button className="off" id="onOff" onClick={handleOnOff}>
        Off
      </button>
    );
  else
    buttonOnOff = (
      <button className="on" id="onOff" onClick={handleOnOff}>
        On
      </button>
    );

  function handleOnOff(e) {
    if (isOn) {
      setIsOn(false);
    } else {
      setIsOn(true);
    }
  }
  /** THIS PART IS USE FOR CONDITIONAL RENDERING */

  return (
    <div className="App">
      <h1>React State and Life Cycle</h1>
      <Form todos={todos} />

      <input placeholder="Enter list here" id="input_todo" />
      <button onClick={handleClick}>Add todo</button>

      {/* THIS PART IS USED FOR CONDITIONAL RENDERING */}
      {buttonOnOff}
    </div>
  );
}

export default App;
