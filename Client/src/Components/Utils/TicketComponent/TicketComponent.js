import InfoTicket from './InfoTicket/InfoTicket';
import Ticket from './Ticket/Ticket';
import './TicketComponent.css'

function TicketComponent(props) {
    return (
        <div className='ticket-component'>
            <Ticket {...props} />
            <InfoTicket {...props} />
        </div>
    )
}

export default TicketComponent;
