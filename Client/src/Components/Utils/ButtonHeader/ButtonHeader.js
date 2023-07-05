import './ButtonHeader.css'
import { useNavigate } from 'react-router-dom';

function ButtonHeader(props){

    const navigate = useNavigate();

    const route = props.route;

    const onClickHandler = async (e) => {
        navigate(route);
    }

    return(
        <button className='button-header' onClick={onClickHandler}>{props.text}</button>
    );
}

export default ButtonHeader