import './UserAvatar.css'
import user from '../../../../../images/usuario.png'
import off from '../../../../../images/apagar.png'

function UserAvatar(){
    return(
        <div className='user-avatar'>
            <section className='log-out'>
                <p>Log out</p>
                <img src={off} alt="button-log-out"/>
            </section>
            <img src={user} alt="user-logo"/>
            <h1>@Username</h1>
        </div>
    )
}

export default UserAvatar