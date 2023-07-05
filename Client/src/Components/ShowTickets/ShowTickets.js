import './ShowTickets.css'
import Logo from '../Utils/Logo/Logo'
import Ticket from '../Utils/TicketComponent/Ticket/Ticket'
import scan from '../../images/smartphone.png'
import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent'

function ShowTickets(props){

    return(
        <div className='show-tickets'>
            <div className='header-show-tickets'>
                <Logo/>
                <ReturnButtonsComponent back="/Profile/Tickets"/>
            </div>
            <div className='image-div'>
                <img src={props.src} alt="event-img"/>
            </div>
            <div className='tickets-list'>
                <h3>Select a ticket to generate its QR code</h3>
                <section className='tickets-container'>
                    <Ticket/>
                    <Ticket/>
                    <Ticket/>
                    <Ticket/>
                    <Ticket/>
                    <Ticket/>
                </section>
                <img src={scan} alt="phone-scan"/>
            </div>
        </div>
    )
}

export default ShowTickets;