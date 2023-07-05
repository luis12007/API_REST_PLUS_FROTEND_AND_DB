import Board from '../../../Utils/Board/Board'
import  './UserTickets.css'
import Searcher from '../../../Utils/Searcher/Searcher'
import TicketsContainer from './TicketsContainer/TicketsContainer'
import money from '../../../../images/signo-de-dolar.png'
import { useNavigate } from 'react-router-dom'

function UserTickets(){

    const navigate = useNavigate();

    const onClickHandler = async (e) => {
        navigate("/Tickets");
    }

    return(
        <div className='user-tickets'>
            <Board/>
            <Searcher text="tickets"/>
            <section className="title-tickets">
                <h2>Los Tickets Obtenidos</h2>
                <section className="title-subline">.</section>
            </section>
            <TicketsContainer/>
        </div>
    )
}

export default UserTickets