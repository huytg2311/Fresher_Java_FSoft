import { BiEdit } from 'react-icons/bi'
import { TiDeleteOutline, TiTick } from 'react-icons/ti'
export const UserRole = ({ item, index, onDeleteData, onUpdateRoleData }) => {
    return (
        <>
            <tr>
                <th scope="row">{index + 1}</th>
                <td>
                    {item.username}
                </td>
                <td>
                    {item.role}
                </td>
                <td>
                    {(item.role === 'Developer' || item.role === 'Manager') ? <TiTick></TiTick> : ''}
                </td>
                <td>
                    {(item.role === 'Manager') ? <TiTick></TiTick> : ''}
                </td>
                <td>
                    <TiTick></TiTick>
                </td>
                <td>
                    <button className="btn btn-primary" onClick={() => { onUpdateRoleData(item) }}> <BiEdit size={20}></BiEdit></button>
                    <button className="btn btn-danger ms-2" onClick={() => onDeleteData(item)}> <TiDeleteOutline size={20}></TiDeleteOutline></button>
                </td>
            </tr>
        </>
    )
}