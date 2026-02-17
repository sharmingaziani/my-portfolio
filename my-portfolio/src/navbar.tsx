// src/components/Navbar.tsx
import React from 'react';
import { Link } from 'react-router-dom';

const Navbar: React.FC = () => {
  return (
    <nav
      style={{
        position: 'fixed',   // <-- sticks navbar to the top
        top: 0,
        left: 0,
        width: '100%',
        padding: '1rem',
        backgroundColor: '#282c34',
        color: 'white',
        zIndex: 1000,        // <-- ensures it stays above other content
      }}
    >
      <Link style={{ margin: '0 1rem', color: 'white', textDecoration: 'none' }} to="/">Home</Link>
      <Link style={{ margin: '0 1rem', color: 'white', textDecoration: 'none' }} to="/work">Work Experience</Link>
      <Link style={{ margin: '0 1rem', color: 'white', textDecoration: 'none' }} to="/hobbies">Hobbies</Link>
      <Link style={{ margin: '0 1rem', color: 'white', textDecoration: 'none' }} to="/projects">Projects</Link>
      <Link style={{ margin: '0 1rem', color: 'white', textDecoration: 'none' }} to="/school">School</Link>
    </nav>
  );
};

export default Navbar;
