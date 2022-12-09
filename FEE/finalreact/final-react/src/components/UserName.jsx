export const UserName = ({ item, index }) => {
    return (
        <>
            {
                (item.status === 'active') ? <option value={item.username}>{item.username}</option> : ''
            }
        </>
    )
}