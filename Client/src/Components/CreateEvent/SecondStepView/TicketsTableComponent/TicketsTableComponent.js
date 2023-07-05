import './TicketsTableComponent.css'
import rotate from '../../../../images/chevron-abajo.png'
import TicketClassComponent from './TicketClassComponent/TicketClassComponent'

function TicketsTableComponent(){

    return(
        <div className='tickets-table-component'>
            <div className='table-header'>
                <section className='title-ticket-table'>
                    <h3>Ticket Class</h3>
                    <img src={rotate} alt="arrow-img" className='title-arrow'/>
                </section>
                <section className='price-ticket-table'>
                    <h3>Price</h3>
                    <img  src={rotate} alt="arrow-img"/>
                </section>
            </div>
            <div className='table-content'>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
                <TicketClassComponent text="Platinum" price="$99.99"/>
            </div>
        </div>
    )
}

export default TicketsTableComponent