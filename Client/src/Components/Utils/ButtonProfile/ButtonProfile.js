import './ButtonProfile.css'
import user from '../../../images/usuario.png'
import { useNavigate } from 'react-router-dom'

function ButtonProfile(props){
    const img = localStorage.getItem('img')
    
    const route = props.route

    const navigate = useNavigate()

    const onClickHandler = async (e) => {
        e.preventDefault();
        navigate(route)
    }

    return (
        <div className='div-button-profile' onClick={onClickHandler}>
            <button className='button-header-profile' >{props.text}</button>
            <img src={img} alt="user-profile" className="rounded-image"/>            
        </div>
    )
}

export default ButtonProfile