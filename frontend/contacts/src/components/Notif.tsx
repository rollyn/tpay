import { toast } from "react-toastify";

const Notif = {
  showSuccess(id: string) {
    toast.success("Contact with ID " + id + " created!", {
      position: toast.POSITION.TOP_CENTER,
    });
  },
  showException(exception: string) {
    toast.error(exception, {
      position: toast.POSITION.TOP_CENTER,
    });
  },
};

export default Notif;
