import './Ticket.css'
import QR from '../../../../images/codigo-qr.png'
import TicketIdentifier from './TicketIdentifier/TicketIdentifier'
import EventInfo from '../../EventInfo/EventInfo'

function Ticket({ title, date, time, place, img }) {
    
    const formattedDate = date.split('T')[0];

    return (
        <div className='ticket'>
            <img src={QR} alt="qr" className='img-qr' />
            <TicketIdentifier title={title} />
            <EventInfo date={formattedDate} time={time} place={place} />
            <div className='img-container'>
                <img src={img} alt="ticket-event" className='img-ticket' />
            </div>
        </div>
    )
}

export default Ticket;
