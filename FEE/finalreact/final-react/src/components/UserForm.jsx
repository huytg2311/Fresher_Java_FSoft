import { useEffect, useState } from "react";
import { v4 as uuidv4 } from "uuid";
import { User } from "./User";
import { isEmpty } from "lodash";
export const UserForm = ({
  userData,
  createData,
  onUpdateData,
  fixingData,
  obj,
  setObj,
}) => {
  const initdata = {
    id: uuidv4(),
    username: "",
    status: false,
    email: "",
  };
  const [value, setValue] = useState(initdata);
  const [username, setUsername] = useState("");
  const [status, setStatus] = useState("");
  const [email, setEmail] = useState("");
  const [errname, setErrName] = useState(false);
  const [errStatus, setStatusErr] = useState(false);
  const [errmail, setErrMail] = useState(false);

  console.log(
    userData.filter((item) => {
    //   item.mail === "alex@gmail.com";
    })
  );
  const onChangeName = (e) => {
    setUsername(e.target.value);
    setValue({ ...value, username: e.target.value });
    validateInputText(username) ? setErrName(false) : setErrName(true);
  };
  const onChangeStatus = (e) => {
    setStatus(e.target.value);
    setValue({ ...value, status: e.target.value });
    validateStatus(status) && setStatusErr(false);
  };
  const onChangeEmail = (e) => {
    setEmail(e.target.value);
    setValue({ ...value, email: e.target.value });
    validateEmail(email) ? setErrMail(false) : setErrMail(true);
    const newArr = userData.filter((item) => item.email === e.target.value);
    if (newArr.length > 0) {
      setErrMail(true);
    }
  };
  const validateInputText = (pram) => {
    let regexText = /^[a-zA-Z ]*$/g;
    if (pram === "" || !regexText.test(pram)) {
      return false;
    } else {
      return true;
    }
  };
  const validateEmail = (pram) => {
    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (!regexEmail.test(pram) || pram === "") {
      return false;
    } else {
      return true;
    }
  };
  const validateStatus = (pram) => {
    if (pram === "" || pram === "none") {
      return false;
    }
    return true;
  };

  const onSubmit = () => {
    !validateInputText(username) && setErrName(true);
    !validateEmail(email) && setErrMail(true);
    !validateStatus(status) && setStatusErr(true);
    if (!errname && !errmail && !errStatus) {
      createData(uuidv4(), value);
      setValue("");
      setUsername("");
      setStatus("");
      setEmail("");
    } else {
      alert("Invalid input");
    }
  };
  useEffect(() => {
    if (obj) {
      setValue({ ...obj });
      setUsername(obj.username);
      setStatus(obj.status);
      setEmail(obj.email);
      !validateInputText(username) && setErrName(true);
      !validateEmail(email) && setErrMail(true);
      !validateStatus(status) && setStatusErr(true);
      setErrName(false);
      setErrMail(false);
      setStatusErr(false);
      var slList = document.getElementById("selectList");
      if (obj.status === "active") {
        slList.disabled = true;
        console.log(slList);
      } else {
        slList.disabled = false;
      }
    }
  }, [obj]);

  const onUpdate = () => {
    if (!errname && !errmail && !errStatus) {
      fixingData(value);
      setObj("");
      setValue("");
      setUsername("");
      setStatus("");
      setEmail("");
    } else {
      alert("Invalid input");
    }
  };
  
  return (
    <div className="row d-grid gap-3">
      <h4 className="row justify-content-center">User Form</h4>
      <div className="row">
        <div className="form-group col-md-6">
          <label htmlFor="userInput">Name</label>
          <input
            id="userInput"
            className={`form-control ${errname ? "is-invalid" : ""}`}
            name="inputValue"
            type="text"
            placeholder="Name..."
            value={username}
            onChange={onChangeName}
          ></input>
          <div className={`text-danger ${errname ? "" : "d-none"}`}>
            *Name required - text only
          </div>
        </div>
        <div className="form-group col-md-6">
          <label htmlFor="userInput">Status</label>
          <select
            className={`form-select ${errStatus ? "is-invalid" : ""}`}
            aria-label="Default select example"
            id="selectList"
            onChange={(e) => onChangeStatus(e)}
            value={status}
          >
            <option value="none">Choose status</option>
            <option value="active">Active</option>
            <option value="notactive">Not Active</option>
          </select>
          <div className={`text-danger ${errStatus ? "" : "d-none"}`}>
            *Status required
          </div>
        </div>
      </div>
      <div className="row">
        <div className="form-group">
          <label htmlFor="userInput">Email</label>
          <input
            id="userInput"
            className={`form-control ${errmail ? "is-invalid" : ""}`}
            name="inputValue"
            type="email"
            placeholder="Email..."
            value={email}
            onChange={onChangeEmail}
          ></input>
          <div className={`text-danger ${errmail ? "" : "d-none"}`}>
            *Email required - email not unique
          </div>
        </div>
      </div>
      <div className="row">
        <button
          className="btn btn-success w-25 ms-3"
          onClick={() => {
            !isEmpty(obj) ? onUpdate() : onSubmit();
          }}
        >
          {" "}
          {isEmpty(obj) ? "Add user" : "Edit"}
        </button>
      </div>
      <h4 className="row justify-content-center">User Table</h4>
      <table className="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">User name</th>
            <th scope="col">Status</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {userData.map((item, index) => {
            return (
              <User
                item={item}
                key={item.id}
                index={index}
                onUpdateData={onUpdateData}
              />
            );
          })}
        </tbody>
      </table>
    </div>
  );
};
