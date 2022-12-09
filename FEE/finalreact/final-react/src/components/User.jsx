import '../fontawesome-free-5.15.4-web/css/all.min.css'
export const User = ({ item, index, onUpdateData }) => {
    return (
        <>
            <tr>
                <th scope="row">{index + 1}</th>
                <td>
                    {item.username}
                </td>
                <td>
                    {
                        (item.status === 'notactive') ? <label className='text-secondary'>Not active</label> : <label>Active</label>
                    }
                </td>
                <td>
                    {item.email}
                </td>
                <td>
                    <button className="btn btn-primary" onClick={() => { onUpdateData(item) }}><i class='fa fa-edit'></i></button>
                </td>
            </tr>
        </>
    )
}