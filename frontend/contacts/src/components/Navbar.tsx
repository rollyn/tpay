import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="flex items-center gap-6 h-10">
      <div className="text-lg mx-2">
        <strong>CONTACT</strong>
      </div>
      <div>
        <ul className="ml-auto flex items-center gap-2 text-sm">
          <li>
            <NavLink to="/contact" className="bg-gray-100 px-2 rounded-lg">
              NEW CONTACT
            </NavLink>
          </li>
          <li>
            <NavLink to="/" className="bg-gray-100 px-2 rounded-lg">
              SEARCH
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
