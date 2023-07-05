import './HeaderWithoutLogin.css'
import ButtonHeader from '../ButtonHeader/ButtonHeader'
import ButtonProfile from '../ButtonProfile/ButtonProfile'
import ButtonSignUp from './ButtonSignUp/ButtonSignUp';

function HeaderWithoutLogin(){
    return(
        <div className='header-without-login'>
            <ButtonSignUp text='Registrate'/>
            <ButtonHeader text='Home' route="/"/>
            <ButtonHeader text='Eventos' route = "/Events"/>
            <ButtonHeader text='Nosotros' route="/AboutUs"/>
            <ButtonHeader text='Redes' route="/FollowUs"/>
        </div>
    )
}

export default HeaderWithoutLogin;