import './TicketIdentifier.css'

function TicketIdentifier(props){
    return(
        <div className='ticket-identifier'>
                <h3>Evento Seleccionado:</h3>
                <p>{props.title}</p>
        </div>
    )
}

export default TicketIdentifier