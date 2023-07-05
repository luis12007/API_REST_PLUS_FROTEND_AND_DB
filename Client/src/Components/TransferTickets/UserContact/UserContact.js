import './UserContact.css'
import {AiOutlineUser} from 'react-icons/ai'

function UserContact(props){
    return(
        <div className='userContactComponent'>
            <input type='checkbox'/>
            <AiOutlineUser className='userIconLogo'/>
            <p>{props.name}</p>
        </div>
    )
}

export default UserContact;