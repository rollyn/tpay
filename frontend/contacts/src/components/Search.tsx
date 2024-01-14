import { FormEvent, useState } from "react";
import axios from "axios";
import { ContactModel } from "./ContactModel";
import ContactDetail from "./ContactDetail";
import { ToastContainer } from "react-toastify";
import Notif from "./Notif";

const BASE_URL = "http://localhost:50000";

const Search = () => {
  const [contact, setContact] = useState<ContactModel>({
    name: "",
    phone: "",
  });

  const [searchId, setSearchId] = useState("");

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const onFieldChange = (event: any) => {
    const searchId = event.target.value;
    setSearchId(searchId);
    setContact({
      name: "",
      phone: "",
    });
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    axios
      .get<ContactModel>(BASE_URL + `/retrieveContactDetails/${searchId}`)
      .then((response) => {
        console.log(response.status, response.data);
        setContact(response.data);
      })
      .catch((err: Error) => {
        const res = err.response.data;
        Notif.showException(res.message);
      });
  };

  return (
    <div>
      <ToastContainer />
      <form onSubmit={handleSubmit} className="max-w-sm mx-auto">
        <div className="mb-5">
          <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            Enter ID to Search
          </label>
          <input
            onChange={onFieldChange}
            type="text"
            id="searchId"
            name="searchId"
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="123"
            required
          />
        </div>
        <button
          type="submit"
          className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
        >
          Search
        </button>
      </form>
      <div>{contact.name ? <ContactDetail contact={contact} /> : ""}</div>
    </div>
  );
};

export default Search;
