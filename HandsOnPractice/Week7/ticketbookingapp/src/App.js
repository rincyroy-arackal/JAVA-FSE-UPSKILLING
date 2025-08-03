import React, { useState } from "react";
import "./App.css";

// Guest Page Component
const GuestPage = () => (
  <div>
    <h2>Welcome, Guest!</h2>
    <p>Here are some flight options you can browse:</p>
    <ul>
      <li>✈️ Mumbai → Delhi</li>
      <li>✈️ Chennai → Bangalore</li>
      <li>✈️ Kolkata → Pune</li>
    </ul>
  </div>
);

// User Page Component
const UserPage = () => (
  <div>
    <h2>Welcome, User!</h2>
    <p>You are now logged in. Please select your flight and book tickets below:</p>
    <ul>
      <li>
        ✈️ Mumbai → Delhi - <button>Book Now</button>
      </li>
      <li>
        ✈️ Chennai → Bangalore - <button>Book Now</button>
      </li>
      <li>
        ✈️ Kolkata → Pune - <button>Book Now</button>
      </li>
    </ul>
  </div>
);

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Element variable for the page content
  let page;
  if (isLoggedIn) {
    page = <UserPage />;
  } else {
    page = <GuestPage />;
  }

  return (
    <div className="App">
      <h1>Flight Ticket Booking App</h1>
      <div>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        )}
      </div>
      <hr />
      {page}
    </div>
  );
}

export default App;
