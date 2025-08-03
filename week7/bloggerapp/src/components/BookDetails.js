import React from 'react';

const BookDetails = ({ books }) => {
  return (
    <div>
      <h2>Book Details</h2>
      {books.map((book, index) => (
        <p key={index}>{book}</p>
      ))}
    </div>
  );
};

export default BookDetails;
