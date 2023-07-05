import './ButtonsBoard.css'
import {useNavigate} from 'react-router-dom'

function ButtonsBoard(){

    const navigate = useNavigate();

    const onClickHandlerTickets = async (e) => {
        e.preventDefault();
        navigate("/Profile/Tickets");
    }

    const onClickHandlerCreateEvents = async (e) => {
        e.preventDefault();
        navigate("/Profile/Board");
    }

    return(
        <div className='buttons-board'>
            <button className="button-1" onClick={onClickHandlerCreateEvents}>Events I will attend</button>
            <button className="button-2" onClick={onClickHandlerTickets}>My tickets</button>
        </div>
    )
}

export default ButtonsBoard