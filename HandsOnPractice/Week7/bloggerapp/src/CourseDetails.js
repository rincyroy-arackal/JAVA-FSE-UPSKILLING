function CourseDetails() {
  const courses = ["React Basics", "React with Redux", "React Native"];
  return (
    <div>
      <h3>🎓 Course Details</h3>
      <ul>
        {courses.map((course, index) => (
          <li key={index}>{course}</li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
