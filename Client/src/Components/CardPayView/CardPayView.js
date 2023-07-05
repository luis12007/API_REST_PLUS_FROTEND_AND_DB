import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent'
import './CardPayView.css'
import {FaRegCreditCard} from 'react-icons/fa'
import InputCard from './InputCard/InputCard'
import {FaCcVisa} from 'react-icons/fa'
import {FaCcMastercard} from 'react-icons/fa'
import swal from 'sweetalert2'
import {useNavigate} from 'react-router-dom'

function CardPayView(){

    const navigate = useNavigate();

    function onClickHandler(){
        swal.fire({
            title: 'Are you sure?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, save!'
          }).then((result) => {
            if (result.isConfirmed) {
              swal.fire(
                'Success!',
              )
                navigate("/Profile/Tickets");
            }
          })
    }


    return(
        <div className='cardPayView'>
            <ReturnButtonsComponent back="/Payment/Select"/>
            <p className='titleCardPayment'>Card Payment</p>
            <FaRegCreditCard className='iconCard'/>
            <section className='addCardSection'>
                <p className='titleCardSection'>Agregar tarjeta de crédito/débito</p>
                <InputCard ph="Nombre" text="Nombre en la tarjeta:"/>
                <section className='targetType'>
                    <InputCard ph="#### - #### - #### - ####" text="Número de tarjeta:"/>
                    <article className='typesOfCards'>
                        <FaCcVisa className='iconVisaCard'/>
                        <FaCcMastercard className='iconMasterCard'/>
                    </article>
                </section>
                <InputCard ph="MM/YY" text="Vencimiento:"/>
                <InputCard ph="###" text="CVV:"/>
            </section>
            <button className='buttonAddCard' onClick={onClickHandler}>Save</button>
        </div>
    )
}

export default CardPayView