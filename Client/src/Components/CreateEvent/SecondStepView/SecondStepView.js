import './SecondStepView.css'
import TicketClassificationComponent from './TicketClassificationComponent/TicketClassificationComponent';
import logo from '../../../images/pinata.png'
import TicketsTableComponent from './TicketsTableComponent/TicketsTableComponent';
import {useNavigate} from 'react-router-dom'

function SecondStepView({ onNextStep, onPreviousStep, onCancelCreate }){

    const navigate = useNavigate()

    function handleNextStep(e){
        e.preventDefault()
        navigate('/Create/ThirdStep')
    }

    function handleCancelCreate(e){
        e.preventDefault()
        navigate('/Profile/Board')
    }
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
                        <button className='btn-cancel' onClick={onPreviousStep}>Cancel</button>
                        <button className='btn-submit' onClick={onNextStep}>Submit</button>
                    </section>
                </section>
            </form>
        </div>
    )
}

export default SecondStepView;