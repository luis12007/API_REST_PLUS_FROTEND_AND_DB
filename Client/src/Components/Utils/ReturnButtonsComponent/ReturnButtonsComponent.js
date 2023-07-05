import './ReturnButtonsComponent.css'
import arrow from '../../../images/flecha-izquierda.png'
import user from '../../../images/usuario.png'
import {useNavigate} from 'react-router-dom'

function ReturnButtonsComponent(props){

    const navigate = useNavigate();

    const route = props.back

    const goBack = () => {
        navigate(route)
    }

    const goProfile = () => {
        navigate("/Profile/Board")
    }

    return (
        <section className='return-btns'>
                    <article className='btn-return'>
                        <img src={arrow} alt="flecha-izquierda" onClick={goBack}/>
                        <p>Back</p>
                    </article>
                    <article className='btn-profile'>
                        <img src={user} alt="usuario" onClick={goProfile}/>
                        <p>Profile</p>
                    </article>
                </section>
    )
}   

export default ReturnButtonsComponent;