// src/pages/Home.tsx
import React, { useEffect } from 'react';
import { Typewriter } from 'react-simple-typewriter';
import './Home.css';

const Home: React.FC = () => {

  useEffect(() => {
    const container = document.getElementById('home-container');
    if (!container) return;

    for (let i = 0; i < 50; i++) {
      const star = document.createElement('div');
      star.className = 'star';
      star.style.top = `${Math.random() * 100}%`;
      star.style.left = `${Math.random() * 100}%`;
      star.style.width = `${Math.random() * 3 + 1}px`;
      star.style.height = star.style.width;
      container.appendChild(star);
    }
  }, []);

  return (
    <div id="home-container" className="home-container">
      <h1 className="flicker" style={{ fontSize: '2.5rem', marginBottom: '1rem' }}>
        <Typewriter
          words={['WELCOME TO MY PORTFOLIO!']}
          loop={1}
          cursor
          cursorStyle="|"
          typeSpeed={100}
          deleteSpeed={50}
          delaySpeed={1000}
        />
      </h1>
      <p style={{ maxWidth: '600px' }}>
        Hi! I'm Sharmin, a software developer interested in building cool projects.
      </p>
    </div>
  );
};

export default Home;
