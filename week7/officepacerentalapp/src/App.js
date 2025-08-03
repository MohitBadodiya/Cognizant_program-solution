import React from 'react';

function App() {
  const office = {
    name: 'Corporate Workspace',
    rent: 55000,
    address: '1234 Tech Park, City Center'
  };

  const officeSpaces = [
    { name: 'Startup Hub', rent: 45000, address: 'Sector 10' },
    { name: 'Premium Suites', rent: 75000, address: 'Business Bay' },
    { name: 'Economy Cabin', rent: 30000, address: 'Innovation Street' },
    { name: 'Executive Office', rent: 90000, address: 'Elite Avenue' }
  ];

  const rentStyle = (rent) => {
    return {
      color: rent < 60000 ? 'red' : 'green'
    };
  };

  return (
    <div>
      {/* Heading of the page */}
      <h1>Office Space Rental App</h1>

      {/* Attribute to display image */}
      <img src="https://www.istockphoto.com/vector/office-workstation-furniture-interior-concept-vector-flat-graphic-design-cartoon-gm1222624922-358828122" alt="Office Space" />

      {/* Display Object data */}
      <h2>Office Details:</h2>
      <p>Name: {office.name}</p>
      <p style={rentStyle(office.rent)}>Rent: {office.rent}</p>
      <p>Address: {office.address}</p>

      {/* Loop through List of Objects */}
      <h2>Available Office Spaces:</h2>
      {officeSpaces.map((space, index) => (
        <div key={index}>
          <p>Name: {space.name}</p>
          <p style={rentStyle(space.rent)}>Rent: {space.rent}</p>
          <p>Address: {space.address}</p>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default App;
