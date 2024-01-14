import { FormEvent, useState } from "react";
import { ContactModel } from "./ContactModel";

import Notif from "./Notif";
import { ToastContainer } from "react-toastify";

const BASE_URL = "http://localhost:50000";

const NewContact = () => {
  const [contact, setContact] = useState<ContactModel>({
    name: "",
    phone: "",
  });

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const onFieldChange = (event: any) => {
    const form_value = event.target.value;

    setContact({ ...contact, [event.target.id]: form_value });
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    axios
      .post(BASE_URL + "/recordContactDetails", contact)
      .then((response) => {
        console.info(response.status, response.data);
        Notif.showSuccess(response.data);
      })
      .catch((err: Error) => {
        const res = err.response.data;
        console.log(res);
        Notif.showException(res.message);
      });
  };

  return (
    <div>
      <ToastContainer />
      <form onSubmit={handleSubmit} className="max-w-sm mx-auto">
        <div className="mb-5">
          <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            Name
          </label>
          <input
            onChange={onFieldChange}
            type="text"
            id="name"
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="Tony Stark"
            required
          />
        </div>
        <div className="mb-5">
          <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
            Phone
          </label>
          <input
            type="text"
            onChange={onFieldChange}
            id="phone"
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="0999999999"
            required
          />
        </div>
        <button
          type="submit"
          className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
        >
          Submit
        </button>
      </form>
    </div>
  );
};

export default NewContact;
