import { ContactModel } from "./ContactModel";

const ContactDetail = ({ contact }: ContactModel) => (
  <div className="mt-5 max-w-sm mx-auto bg-blue-300 shadow-md text-xl block w-full p-2.5 rounded-lg">
    <div>
      <div>
        Name: <strong>{contact.name}</strong>
      </div>
      <div>Phone: {contact.phone}</div>
    </div>
  </div>
);

export default ContactDetail;
