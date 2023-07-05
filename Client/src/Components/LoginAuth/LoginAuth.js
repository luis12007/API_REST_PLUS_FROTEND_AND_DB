import Form from './Form/Form'
import Logo from '../Utils/Logo/Logo'
import './LoginAuth.css'

function LoginAuth(){
    return(
        <div className='form-container-logauth'>
            <div className='form-logo'>
                <Logo/>
            </div>
            <div className='form-loginauth'>
                <Form/>
            </div>
        </div>
    )
}

export default LoginAuth