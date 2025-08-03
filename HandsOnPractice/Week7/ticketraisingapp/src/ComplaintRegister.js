import React, { useState } from "react";

function ComplaintRegister() {
  const [name, setName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!name.trim() || !complaint.trim()) {
      alert("Please fill in all fields.");
      return;
    }

    const referenceNumber = "REF" + Math.floor(100000 + Math.random() * 900000);
    alert(
      `Complaint submitted successfully!\nReference Number: ${referenceNumber}`
    );

    // Reset form
    setName("");
    setComplaint("");
  };

  return (
    <div style={{ maxWidth: "500px", margin: "auto", padding: "20px" }}>
      <h2>Complaint Registration</h2>
      <form onSubmit={handleSubmit}>
        <label>Employee Name:</label>
        <br />
        <input
          type="text"
          placeholder="Enter your name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <br />
        <br />
        <label>Complaint:</label>
        <br />
        <textarea
          rows="5"
          placeholder="Describe your issue..."
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          required
        ></textarea>
        <br />
        <br />
        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
