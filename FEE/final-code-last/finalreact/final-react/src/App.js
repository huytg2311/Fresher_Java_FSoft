import { useEffect, useState } from "react";
import './fontawesome-free-5.15.4-web/css/all.min.css'

const OPTIONS = [
  {
    id: 1,
    label: "Khoi Lop 1",
    value: "opt1",
  },
  {
    id: 2,
    label: "Khoi Lop 2",
    value: "opt2",
  },
  {
    id: 3,
    label: "Khoi Lop 3",
    value: "opt3",
  },
  {
    id: 4,
    label: "Khoi Lop 4",
    value: "opt4",
  },
];

const OPTIONS2 = [
  {
    id: 1,
    label: "1A1",
    value: "a1",
  },
  {
    id: 2,
    label: "2A2",
    value: "a2",
  },
  {
    id: 3,
    label: "3A3",
    value: "a3",
  },
  {
    id: 4,
    label: "4A4",
    value: "a4",
  },
];

const LIST = [
  {
    id: 1,
    name: "Ngoc Khoi",
    gender: "Nam",
    date: "10/05/2001",
    classRoom: "Khoi Lop 1",
    className: "1A1",
  },
  {
    id: 2,
    name: "Ngoc Khoi",
    gender: "Nam",
    date: "10/05/2001",
    classRoom: "Khoi Lop 1",
    className: "1A1",
  },
];
const TodoForm = (props) => {
  const { onCancel, onSave, todoItem } = props;
  const [form, setForm] = useState({
    taskName: "",
    gender: "",
    date: "",
    taskCategory: "",
    taskLop: "",
    done: false,
  });
  const [errors, setErrors] = useState({});
  const handleValueChanged = ({ target: { value, name } }) =>
    setForm({ ...form, [name]: value });
    const handleValueChanged2 = ({ target: { value, name } }) =>
    setForm({ ...form, [name]: value });
  const handleCheckedChanged = ({ target: { checked, name } }) =>
    setForm({ ...form, [name]: checked });
  const handleFormSubmit = (event) => {
    event.preventDefault();
    const _errors = {};
    if (!form.taskName.length) {
      _errors.taskName = "Name is required.";
    } else if (!form.taskName.match("^[A-Za-z\\s]+$")) {
      _errors.taskName = "Please input task name > 4 characters";
    }
    if (!form.taskCategory) {
      _errors.taskCategory = "Khoi Lop is required.";
    }

    if (!form.date.length) {
      _errors.date = "Date is required.";
    }

    

    if (!form.taskLop) {
      _errors.taskLop = "Lop is required.";
    }
    

    setErrors(_errors);
    if (Object.keys(_errors).length) {
      return;
    }
    onSave(form);
    handleResetForm();
  };
  const handleResetForm = () => {
    setForm({
      taskName: "",
      taskCategory: "",
      taskLop: "",
      important: false,
    });
    setErrors({});
    onCancel();
  };
  useEffect(() => {
    if (todoItem) {
      setForm(todoItem);
    }
  }, [todoItem]);
  return (
    <div
      className="all"
      style={{ display: "flex", justifyContent: "space-between" }}
    >
      <div className="card-body" style={{ width: "20%" }}>
        <div className="card-title" style={{fontWeight: "bolder"}}>B. THONG TIN HOC SINH</div>
        <form onSubmit={handleFormSubmit} onReset={handleResetForm}>
          <div className="form-row">
            <div className="col">
              <div className="form-group">
                <label htmlFor="taskNameInput">Ho va Ten Hoc Sinh:</label>
                <input
                  className={`form-control ${
                    errors.taskName ? "is-invalid" : ""
                  }`}
                  id="taskNameInput"
                  name="taskName"
                  value={form.taskName}
                  onChange={handleValueChanged}
                  placeholder="Nhap ho va ten"
                />
                <div className="invalid-feedback">{errors.taskName}</div>
              </div>
            </div>

            <div
              className="col"
              style={{ display: "flex", marginTop: "10px"}}
            >
              <div class="form-group">
                <div>
                  <label style={{marginBottom: "7px"}} htmlFor="taskNameInput">Gioi Tinh: </label>
                </div>
                <input
                  type="radio"
                  id="customRadio1"
                  name="customRadio"
                  class="custom-control-input"
                />
                <label class="custom-control-label" for="customRadio1">
                  Nam
                </label>

                <input
                  type="radio"
                  id="customRadio2"
                  name="customRadio"
                  class="custom-control-input"
                  style={{marginLeft: "10px"}}
                />
                <label class="custom-control-label" for="customRadio2">
                  Nu
                </label>

                <input
                  type="radio"
                  id="customRadio2"
                  name="customRadio"
                  class="custom-control-input"
                  style={{marginLeft: "10px"}}

                />
                <label class="custom-control-label" for="customRadio2">
                  Khac
                </label>
              </div>

              <div style={{marginLeft: "6.4rem" }}>
                <label htmlFor="taskNameInput">Ngay Sinh: </label>
                <input
                  className={`form-control ${
                    errors.date ? "is-invalid" : ""
                  }`} type='date' max="2022-11-03"
                  id="date"
                  name="date"
                  value={form.date}
                  onChange={handleValueChanged}
                  style={{width: "139%"}}
                />
                <div className="invalid-feedback">{errors.date}</div>
              </div>
            </div>

            <div style={{ display: "flex", justifyContent: "space-between" , marginTop: "10px"}}>
              <div className="col">
                <div className="form-group">
                  <label htmlFor="taskCategory">Khoi Lop</label>
                  <select
                    className={`form-control ${
                      errors.taskCategory ? "is-invalid" : ""
                    }`}
                    id="taskCategory"
                    name="taskCategory"
                    value={form.taskCategory}
                    onChange={handleValueChanged}
                  >
                    <option value="">--- Chon Khoi Lop ---</option>
                    {OPTIONS.map((it) => (
                      <option key={it.id} value={it.value}>
                        {it.label}
                      </option>
                    ))}
                  </select>
                  <div className="invalid-feedback">{errors.taskCategory}</div>
                </div>
              </div>

              <div className="col"style={{marginLeft: "3rem"}}>
                <div className="form-group">
                  <label htmlFor="taskCategory">Lop</label>

                  <select
                    className={`form-control ${
                      errors.taskLop ? "is-invalid" : ""
                    }`}
                    id="tastaskLopkCategory"
                    name="taskLop"
                    value={form.taskLop}
                    onChange={handleValueChanged2}
                  >
                    <option value="">--- Chon Lop ---</option>
                    {OPTIONS2.map((it2) => (
                      <option key={it2.id} value={it2.value}>
                        {it2.label}
                      </option>
                    ))}
                  </select>
                  <div className="invalid-feedback">{errors.taskLop}</div>
                </div>
              </div>
            </div>
          </div>
          <div className="form-row align-items-center" style={{ gap: 12, marginTop: "30px" }}>
            <div className="text-danger">{errors.status}</div>
            <button type="submit" className="btn btn-primary">
              Luu thong tin dong phi
            </button>
          
          </div>
        </form>
      </div>

      <div className="card-body">
        <div className="card-title" style={{fontWeight: "bolder"}}>
          A. CAC KHOAN PHI CHO HOC SINH KHOI TIEU HOC
        </div>
        <table className="table table-hover">
          <thead>
            <tr>
              <th>Cac Khoan Phi</th>
              <th>Dong Tung Thang</th>
              <th>Dong Theo Ky</th>
              <th>Dong The Nam Hoc</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Hoc Phi</td>
              <td>
                <input type="radio" name='task-radio'/>
                <p>3.700.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio'/>
                <p>10.130.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio'/>
                <p>31.960.000</p>
              </td>
            </tr>
            <tr>
              <td>Ban Tru</td>
              <td>
                <input type="radio" name='task-radio2'/>
                <p>500.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio2'/>
                <p>2.500.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio2'/>
                <p>4.500.000</p>
              </td>
            </tr>
            <tr>
              <td>Tien An</td>
              <td>
                <input type="radio" name='task-radio3'/>
                <p>440.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio3'/>
                <p>2.156.000</p>
              </td>
              <td>
                <input type="radio" name='task-radio3'/>
                <p>4.224.000</p>
              </td>
            </tr>
          </tbody>
        </table>{" "}
      </div>
    </div>
  );
};
const TaskList = (props) => {
  const { list, onSelectItem, onDeleteItem } = props;
  return (
    <div className="card">
      <div className="card-body">
        <div className="card-title" style={{fontWeight: "bolder"}}>C. DANH SACH HOC SINH VA DONG PHI</div>
        <table className="table table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>Ho Va Ten HS</th>
              <th>Gioi Tinh</th>
              <th>Ngay Sinh</th>
              <th>Lop</th>
              <th>
                Cac Khoan Phi
                <th>Hoc Phi</th>
                <th style={{paddingLeft: "20px"}}>Ban Tru</th>
                <th style={{paddingLeft: "20px"}}>Tien An</th>
              </th>
              <th>Tong Tien</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Dinh Bao An</td>
              <td>Nam</td>
              <td>07/08/2014</td>
              <td>1A1</td>
              <td>
                <td>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
              </td>
              <td>500</td>
              <td>
              <button
                    className="btn btn-primary  "
                    onClick={(e) => {
                      e.stopPropagation();
                      onDeleteItem(it);
                    }}
                  >
                    <i className="fa fa-edit"></i>
                  </button>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>Dinh Tien Minh</td>
              <td>Nam</td>
              <td>07/08/2014</td>
              <td>1A1</td>
              <td>
                <td>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
              </td>
              <td>500</td>
              <td>
              <button
                    className="btn btn-primary  "
                    onClick={(e) => {
                      e.stopPropagation();
                      onDeleteItem(it);
                    }}
                  >
                    <i className="fa fa-edit"></i>
                  </button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Dinh Tue Nhi</td>
              <td>Nu</td>
              <td>07/08/2014</td>
              <td>1A1</td>
              <td>
                <td>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
                <td style={{paddingLeft: "20px"}}>3.700.000</td>
              </td>
              <td>500</td>
              <td>
              <button
                    className="btn btn-primary  "
                    onClick={(e) => {
                      e.stopPropagation();
                      onDeleteItem(it);
                    }}
                  >
                    <i className="fa fa-edit"></i>
                  </button>
              </td>
            </tr>
            
          </tbody>
        </table>{" "}
      </div>
    </div>
  );
};
const App = () => {
  const [todoList, setTodoList] = useState(LIST);
  const [todo, setTodo] = useState();
  const handleSave = (todoItem) => {
    const nextList = [...todoList];
    if (!todo) {
      nextList.push({
        ...todoItem,
        id: Math.random(),
      });
    } else {
      const index = todoList.findIndex((it) => it.id === todoItem.id);
      nextList[index] = todoItem;
    }
    setTodoList(nextList);
  };
  const handleCancel = () => {
    setTodo(undefined);
  };
  const handleDeleteItem = (todo) => {
    if (window.confirm("Delete item: " + todo.taskName)) {
      let nextList = [...todoList];
      nextList = nextList.filter((it) => it.id !== todo.id);
      setTodoList(nextList);
    }
  };
  return (
    <div className="container" style={{ marginLeft: 100 }}>
      <TodoForm onSave={handleSave} onCancel={handleCancel} todoItem={todo} />
      <div className="mb-2"></div>
      <TaskList
        list={todoList}
        onSelectItem={setTodo}
        onDeleteItem={handleDeleteItem}
      />
    </div>
  );
};
export default App;
