import './App.css';
import { UserForm } from './components/UserForm';
import { v4 as uuidv4 } from 'uuid';
import { useState } from "react";
import { UserRoleForm } from './components/UserRoleForm';

function App() {
  const arr = [
    {
      id: uuidv4(),
      username: 'Tuan Doan',
      status: 'active',
      email: 'tuandoan@gmail.com'
    },
    {
      id: uuidv4(),
      username: 'Linh Ho',
      status: 'notactive',
      email: 'linhho@gmail.com'
    },
    {
      id: uuidv4(),
      username: 'Alex Ferguson',
      status: 'active',
      email: 'alex@gmail.com'
    },
    {
      id: uuidv4(),
      username: 'Thinh Dam',
      status: 'active',
      email: 'thinhdam@gmail.com'
    },
  ]
  const array = [
    {
      id: uuidv4(),
      username: 'Tuan Doan',
      role: 'Developer',
      creator: 'x',
      editor: '',
      view: 'x',
    },
    {
      id: uuidv4(),
      username: 'Thinh Dam',
      role: 'Support',
      creator: '',
      editor: '',
      view: 'x',
    }, {
      id: uuidv4(),
      username: 'Alex Ferguson',
      role: 'Manager',
      creator: 'x',
      editor: 'x',
      view: 'x',
    },
  ]
  const [userData, setUserData] = useState(arr)
  const [userRoleData, setUserRoleData] = useState(array)
  const [form, setForm] = useState(false)
  const [obj, setObj] = useState(null)
  const [object, setObject] = useState(null)


  const createData = (uuid, pram) => {
    (pram.username && pram.status && pram.email !== '') && userData.push({ ...pram, id: uuid })
    const newData = [...userData]
    setUserData(newData)
    console.log(newData)
  }
  const createRoleData = (uuid, pram) => {
    (pram.username && pram.role !== '') && userRoleData.push({ ...pram, id: uuid })
    const newData = [...userData]
    setUserData(newData)
    console.log(newData)
  }

  const onDeleteData = (pram) => {
    userRoleData.map((item, index) => {
      if (item.id === pram.id) {
        if (window.confirm(`Do you want to delete ${item.username}'s role `))
          userRoleData.splice(index, 1)
      } else return item
    })
    const newData = [...userRoleData]
    setUserRoleData(newData)
  }

  // hide data in input update
  const onUpdateData = (pram) => {
    setObj(pram)
  }

  // click update
  const fixingData = (pram) => {
    console.log(pram)
    userData.map((item, index) => {
      if (item.id === pram.id) {
        userData.splice(index, 1, pram)
      } else return item
    })
    const newData = [...userData]
    setUserData(newData)
  }
  const onUpdateRoleData = (pram) => {
    setObject(pram)
  }
  const fixingRoleData = (pram) => {
    console.log(pram)
    userRoleData.map((item, index) => {
      if (item.id === pram.id) {
        userRoleData.splice(index, 1, pram)
      } else return item
    })
    const newData = [...userRoleData]
    setUserRoleData(newData)
  }

  return (
    <div className='container-fluid'>
      <div className='row'>
        <div className='col-md-4 d-flex flex-column d-grid gap-2 ms-4' style={{ height: '500px' }}>
          <h4 className='row w-50 justify-content-center'>Menu Item</h4>
          <button className='row btn btn-primary w-50' onClick={() => { setForm(false) }}>User Manager</button>
          <button className='row btn btn-info w-50' onClick={() => { setForm(true) }}>Role Manager</button>
        </div>
        <div className='col'>
          {
            !form ? <UserForm userData={userData} createData={createData} onUpdateData={onUpdateData} fixingData={fixingData} obj={obj} setObj={setObj}></UserForm>
              : <UserRoleForm userData={userData} userRoleData={userRoleData} createRoleData={createRoleData} onDeleteData={onDeleteData} onUpdateRoleData={onUpdateRoleData} fixingRoleData={fixingRoleData} object={object} setObject={setObject}></UserRoleForm>
          }

        </div>
      </div>
    </div>
  );
}

export default App;
