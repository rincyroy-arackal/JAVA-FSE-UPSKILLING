import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeeList() {
  const employees = [
    { id: 1, name: "Alice", position: "Manager" },
    { id: 2, name: "Bob", position: "Engineer" },
    { id: 3, name: "Charlie", position: "Designer" }
  ];

  return (
    <div>
      <h2>Employee List</h2>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeeList;
