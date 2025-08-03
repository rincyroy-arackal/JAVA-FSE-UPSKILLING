import React from "react";
import "./App.css";

// Single office object
const office = {
  name: "Cozy Workspace",
  rent: 55000,
  address: "1st Floor, Tech Park, Bangalore",
  image: "https://via.placeholder.com/400x200"
};

// List of office spaces
const officeList = [
  {
    name: "Modern Office",
    rent: 45000,
    address: "2nd Floor, Tech City",
    image: "https://via.placeholder.com/400x200"
  },
  {
    name: "Premium Office",
    rent: 75000,
    address: "5th Avenue, Downtown",
    image: "https://via.placeholder.com/400x200"
  },
  {
    name: "Shared Desk",
    rent: 30000,
    address: "Co-working Hub",
    image: "https://via.placeholder.com/400x200"
  }
];

// Component to render a single office
const OfficeCard = ({ name, rent, address, image }) => {
  const rentStyle = {
    color: rent > 60000 ? "green" : "red"
  };

  return (
    <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px" }}>
      <h2>{name}</h2>
      <img src={image} alt={name} width="400" height="200" />
      <p>{address}</p>
      <p style={rentStyle}>Rent: ₹{rent}</p>
    </div>
  );
};

function App() {
  return (
    <div className="App">
      <h1>Office Space Rental App</h1>
      <OfficeCard {...office} />
      <hr />
      <h2>Available Office Listings</h2>
      {officeList.map((item, index) => (
        <OfficeCard key={index} {...item} />
      ))}
    </div>
  );
}

export default App;
