import Todo from "./Todo";

export default function Form({ todos }) {
  return (
    <>
      {todos.map((todo) => {
        return (
          <>
            <Todo todo={todo} key={todo} />
          </>
        );
      })}
    </>
  );
}
