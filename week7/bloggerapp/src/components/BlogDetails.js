import React from 'react';

const BlogDetails = ({ blogs }) => {
  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <p key={index}>{blog}</p>
      ))}
    </div>
  );
};

export default BlogDetails;
