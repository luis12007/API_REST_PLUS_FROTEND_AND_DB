import './PaymentMethod.css'
import {FaRegCreditCard} from 'react-icons/fa'
import {BsCashCoin} from 'react-icons/bs'
import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent';
import {useNavigate} from 'react-router-dom'

function PaymentMethod(){

    const navigate = useNavigate();

    function onClickHandlerCash(){
        navigate('/Payment/Select/Cash')
    }

    function onClickHandlerCard(){
        navigate('/Payment/Select/Card')
    }

    return(
        <div className='paymentMethod'>
            <ReturnButtonsComponent back="/Payment"/>
            <p className='titlePaymentMethod'>Select a Payment Method</p>
            <p className='line'></p>
            <section className='optionsContainer'>
                <div className='cardOption'>
                    <FaRegCreditCard className='iconCard' onClick={onClickHandlerCard}/>
                    <p>Payment with credit card</p>
                </div>
                <div className='cashOption'>
                    <BsCashCoin className='iconCash' onClick={onClickHandlerCash}/>
                    <p>Payment with cash</p>
                </div>
            </section>
        </div>
    )
}

export default PaymentMethod;