import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [view, setView] = useState('book');  // book | blog | course

  const books = ['React Guide', 'JavaScript Essentials', 'Learning ECMAScript'];
  const blogs = ['React Conditional Rendering', 'JSX Deep Dive', 'Understanding Keys in React'];
  const courses = ['React Basics', 'Advanced React Patterns', 'Full Stack Development'];

  // Method 1: if-else
  let page;
  if (view === 'book') {
    page = <BookDetails books={books} />;
  } else if (view === 'blog') {
    page = <BlogDetails blogs={blogs} />;
  } else {
    page = <CourseDetails courses={courses} />;
  }

  return (
    <div>
      <h1>Blogger App</h1>

      {/* Buttons to switch views */}
      <button onClick={() => setView('book')}>Book Details</button>
      <button onClick={() => setView('blog')}>Blog Details</button>
      <button onClick={() => setView('course')}>Course Details</button>

      {/* Conditional Rendering using if-else variable */}
      {page}

      {/* Method 2: Ternary Operator */}
      {view === 'book' ? <p>Currently Viewing Books</p> : view === 'blog' ? <p>Currently Viewing Blogs</p> : <p>Currently Viewing Courses</p>}

      {/* Method 3: Logical && */}
      {view === 'book' && <p>(Logical && Render) Book List Loaded</p>}
    </div>
  );
}

export default App;
