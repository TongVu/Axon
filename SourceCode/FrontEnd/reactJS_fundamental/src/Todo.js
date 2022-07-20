export default function Todo({ todo }) {
  return (
    <>
      <h2 key={todo}>{todo}</h2>
      <hr />
    </>
  );
}
