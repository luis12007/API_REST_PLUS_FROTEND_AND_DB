import LocalitieComponent from './LocalitieComponent/LocalitieComponent';
import './LocalitiesInfoComponent.css'
import {BsTicket} from 'react-icons/bs'
import { useNavigate } from 'react-router-dom';

function LocalitiesInfoComponent(){

    const navigate = useNavigate();

    const handleBuy = () => {
        navigate('/Event/Select')
    }

    return (
        <div className='localities-info-component'>
            <h2 className='identifier'>Localities</h2>
            <p className='line'></p>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <LocalitieComponent name="Platinum" value="$125.00"/>
            <p className='note'>Nota: *Aplica cargo adicional por servicio TicketYa $10.00</p>
            <button className='btn-buy' onClick={handleBuy}>
                Buy
                <BsTicket className='ticket-icon'/>
            </button>
        </div>
    )
}

export default LocalitiesInfoComponent;