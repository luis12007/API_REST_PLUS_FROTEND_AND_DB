import './AuthComponent.css'
import google from '../../../../images/google.png'
import user from '../../../../images/usuario.png'
import { useNavigate } from 'react-router-dom'
import swal from 'sweetalert2'

function AuthComponent(){

    const navigate = useNavigate()

    const onClickHandler = async (e) => {
        e.preventDefault();
        swal.fire({
            position: 'center-center',
            icon: 'success',
            title: 'Signed up successfully!',
            showConfirmButton: false,
            timer: 1500
          })
        navigate('/Auth')
    }

    return(
        <div className='auth-div'>
            <button className="button-google" onClick={onClickHandler}>
                <img src={google} alt="google-logo"/>
                <p>Sign up with Google</p>
            </button>
            <div className='div-state-auth'>
                <img src={user} alt="user-logo"/>
                <p>unauthenticated</p>
            </div>
        </div>
    )
}

export default AuthComponent