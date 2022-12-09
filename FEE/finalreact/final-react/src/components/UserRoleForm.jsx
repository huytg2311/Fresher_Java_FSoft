import { useEffect, useState } from "react"
import { v4 as uuidv4 } from 'uuid';
import { UserName } from "./UserName";
import { UserRole } from "./UserRole";
import { isEmpty } from 'lodash';
export const UserRoleForm = ({ userData, userRoleData, createRoleData, onDeleteData, onUpdateRoleData, fixingRoleData, object, setObject }) => {
    const initdata = {
        id: uuidv4(),
        username: '',
        role: '',
    }
    const [value, setValue] = useState(initdata)
    const [username, setUsername] = useState('')
    const [role, setRole] = useState('')
    const onChangeName = (e) => {
        setUsername(e.target.value)
        setValue({ ...value, username: e.target.value })
    }
    const onChangeRole = (e) => {
        setRole(e.target.value)
        setValue({ ...value, role: e.target.value })
    }

    const onSubmit = () => {
        createRoleData(uuidv4(), value)
        setValue('')
        setRole('')
        setUsername('')
    }

    useEffect(() => {
        if (object) {
            setValue({ ...object })


            setUsername(object.username)
            setRole(object.role)

        }

    }, [object])
    const onUpdate = () => {
        fixingRoleData(value)
        setObject('')
        setValue("")
        setUsername('')
        setRole('')
    }


    return (
        <div className="row d-grid gap-3">
            <h4 className="row justify-content-center">User Role Form</h4>
            <div className="row">
                <div className="form-group col-md-6">
                    <label htmlFor="userInput">Select User Name</label>
                    <select class="form-select" aria-label="Default select example" id='selectList' onChange={(e) => onChangeName(e)} value={username}>
                        <option selected>Select role</option>
                        {
                            userData.map((item, index) => {
                                return (
                                    <UserName item={item} key={index}></UserName>
                                )
                            })
                        }
                    </select>
                </div>
                <div className="form-group col-md-6">
                    <label htmlFor="userInput">Select Role</label>
                    <select class="form-select" aria-label="Default select example" id='selectList' onChange={(e) => onChangeRole(e)} value={role}>
                        <option selected>Select role</option>
                        <option value="Developer" >Developer</option>
                        <option value="Support" >Support</option>
                        <option value="Manager" >Manager</option>
                    </select>
                </div>
            </div>
            <div className="row">
                <button className="btn btn-success w-25 ms-3" onClick={() => { { (!isEmpty(object)) ? onUpdate() : onSubmit() } }}>{(isEmpty(object)) ? ' Add role for user' : 'Edit'}</button>
            </div>
            <h4 className="row justify-content-center">User Role Table</h4>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">User name</th>
                        <th scope="col">Role</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Editor</th>
                        <th scope="col">View</th>
                        <th scope="col"></th>

                    </tr>
                </thead>
                <tbody>
                    {userRoleData.map((item, index) => {
                        return (
                            <UserRole item={item} key={item.id} index={index} onDeleteData={onDeleteData} onUpdateRoleData={onUpdateRoleData} />
                        )
                    })}
                </tbody>
            </table>


        </div>
    )
}