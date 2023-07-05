import './ProfileContainer.css'
//import UserTickets from './UserTickets/UserTickets'
//import UserBoard from './UserBoard/UserBoard'
import UserEventsCreated from '../UserEventsCreated/UserEventsCreated' 

function ProfileContainer(){
    return(
        <div className='profile-container'>
            <UserEventsCreated/>
        </div>
    )
}

export default ProfileContainer