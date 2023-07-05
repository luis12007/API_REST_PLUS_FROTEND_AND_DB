import './SecondStepView.css'
import TicketClassificationComponent from './TicketClassificationComponent/TicketClassificationComponent';
import logo from '../../../images/pinata.png'
import TicketsTableComponent from './TicketsTableComponent/TicketsTableComponent';
function SecondStepView(){
    return(
        <div className='second-step-create-event'>
            <form className='second-step-form'>
                <section className='title-first-step'>
                    <img src={logo} alt="pinata-title"/>
                    <h2>Create Event</h2>
                </section>
                <TicketClassificationComponent/>
                <TicketsTableComponent/>
                <section className='div-actions-btns'>
                    <section className='actions-btns'>
                        <button className='btn-cancel'>Cancel</button>
                        <button className='btn-submit'>Submit</button>
                    </section>
                </section>
            </form>
        </div>
    )
}

export default SecondStepView;