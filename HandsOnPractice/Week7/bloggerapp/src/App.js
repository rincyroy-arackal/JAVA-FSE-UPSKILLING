import React, { useState } from "react";
import "./App.css";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {
  const [active, setActive] = useState("book");

  let displayComponent;

  // Conditional Rendering using if/else
  if (active === "book") {
    displayComponent = <BookDetails />;
  } else if (active === "blog") {
    displayComponent = <BlogDetails />;
  } else {
    displayComponent = <CourseDetails />;
  }

  return (
    <div className="App">
      <h1>📘 Blogger App</h1>

      <div style={{ marginBottom: "20px" }}>
        <button onClick={() => setActive("book")}>Book Details</button>
        <button onClick={() => setActive("blog")}>Blog Details</button>
        <button onClick={() => setActive("course")}>Course Details</button>
      </div>

      {/* Element variable rendering */}
      {displayComponent}

      {/* Ternary Operator Example */}
      <p>{active === "course" ? "Viewing Courses" : "Not viewing Courses"}</p>

      {/* Logical AND rendering */}
      {active === "blog" && <p>🧠 You are reading blogs!</p>}
    </div>
  );
}

export default App;
