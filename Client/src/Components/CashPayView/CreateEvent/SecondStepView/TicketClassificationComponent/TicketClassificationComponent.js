import './TicketClassificationComponent.css'
import alert from '../../../../images/signo-de-exclamacion.png'
import pencil from '../../../../images/lapiz.png'
import InputComponent from './InputComponent/InputComponent';
import PriceComponent from './PriceComponent/PriceComponent';
import PaymentComponent from './PaymentComponent/PaymentComponent';

function TicketClassificationComponent(){
    return(
        <div className='ticket-classification-component'>
            <section className='ticket-field-description'>
                <img src={pencil} alt="pencil-ticket-title"/>
                <section className='ticket-field-title'>
                    <section className='ticket-title'>
                        <h3>Ticket Classification</h3>
                        <img src={alert} alt="alert-img"/>
                    </section>
                    <p>Note: You can only specify a maximum of categories
                         based on the available space of the specified event venue</p>
                </section>
            </section>
            <section className='ticket-input-fields'>
                <InputComponent/>
                <PriceComponent/>
                <PaymentComponent/>
            </section>
        </div>
    )
}

export default TicketClassificationComponent;