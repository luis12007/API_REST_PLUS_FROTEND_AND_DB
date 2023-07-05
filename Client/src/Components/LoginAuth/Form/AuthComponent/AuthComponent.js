import GenericButton from '../../../Utils/GenericButton/GenericButton'
import './AuthComponent.css'
import google from '../../../../images/google.png'
import user from '../../../../images/usuario.png'

function AuthComponent(){
    return(
        <div className='log-auth-div'>
            <GenericButton className="google">
                <img src={google} alt="google-logo"/>
                <p>Logged with Google</p>
            </GenericButton>
            <div className='div-state-log-auth'>
                <img src={user} alt="user-logo"/>
                <p>authenticated</p>
            </div>
        </div>
    )
}

export default AuthComponent