import './TicketPayComponent.css'
import deletelogo from '../../../../../images/eliminar.png'


function TicketPayComponent(props){
    return(
        <div className='ticketPayComponent'>
            <section className='descriptionTicketToPay'>
                <article className='valuesOfTicket'>
                    <input type='checkbox'/>
                    <p>{props.text}</p>
                </article>
                <img src={deletelogo}/>
            </section>
            <p className='typePay'>{props.type}</p>
            <p className='priceOfPay'>{props.price}</p>
            <p className='surchargePay'>{props.surcharge}</p>
            <p className='totalPay'>{props.total}</p>        
        </div>
    )
}

export default TicketPayComponent;