import "./App.css";
import "react-toastify/dist/ReactToastify.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import NewContact from "./components/NewContact";
import Search from "./components/Search";

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Search />} />
          <Route path="/contact" element={<NewContact />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
