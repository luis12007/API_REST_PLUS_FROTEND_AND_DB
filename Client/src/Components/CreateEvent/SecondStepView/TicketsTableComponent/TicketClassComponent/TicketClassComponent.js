import './TicketClassComponent.css'
import pencil from '../../../../../images/lapiz.png'
import trash from '../../../../../images/eliminar.png'

function TicketClassComponent(props){
    return(
        <div className='ticket-class-component'>
            <section className='ticket-type'>
                <p>{props.text}</p>
                <section className='ticket-btns'>
                    <img src={pencil} alt="pencil" className='edit-ticket'/>
                    <img src={trash} alt="trash" className='delete-ticket'/>
                </section>
            </section>
            <section className='ticket-price'>
                <p>{props.price}</p>
            </section>
        </div>
    )
}

export default TicketClassComponent