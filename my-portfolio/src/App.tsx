import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './navbar';
import Home from './pages/home';
import WorkExperience from './pages/work';
import Hobbies from './pages/hobbies';

const App: React.FC = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/work" element={<WorkExperience />} />
        <Route path="/hobbies" element={<Hobbies />} />
      </Routes>
    </Router>
  );
};

export default App;
