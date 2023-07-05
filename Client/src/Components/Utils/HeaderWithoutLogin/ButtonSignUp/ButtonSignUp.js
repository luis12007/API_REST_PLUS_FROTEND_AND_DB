import './ButtonSignUp.css'
import signup from '../../../../images/register.png'
import { useNavigate } from 'react-router-dom'

function ButtonSignUp(props){

    const navigate = useNavigate();

    const onClickHandler = async (e) => {
        navigate("/SignUp");
    }

    return(
        <div className='div-button-signup'>
            <button className='button-header-signup' onClick={onClickHandler}>{props.text}</button>
            <img src={signup} alt="user-signup"/>            
        </div>

    )
}

export default ButtonSignUp