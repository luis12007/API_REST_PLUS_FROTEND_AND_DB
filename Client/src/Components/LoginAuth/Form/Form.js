import AuthComponent from './AuthComponent/AuthComponent'
import './Form.css'
import welcome from '../../../images/felpudo.png'
import { useNavigate } from 'react-router-dom'
import swal from 'sweetalert2'

function Form(){

    const navigate = useNavigate();

    const onClickHandlerHome = async (e) => {
        e.preventDefault();
        swal.fire({
            position: 'center-center',
            icon: 'success',
            title: 'Access granted',
            showConfirmButton: false,
            timer: 1500
          })
        navigate("/Home");
    }

    return(
        <div className='form-log-in-auth'>
            <h1>Welcome!</h1>
            <img src={welcome} alt="welcome-img"/>
            <AuthComponent/>
            <button className="btn-access" onClick={onClickHandlerHome}>
            <p>Access</p>
            </button>
        </div>
    )
}

export default Form