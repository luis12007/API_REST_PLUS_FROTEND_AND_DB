import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent'
import './CashPayView.css'
import {BsCashCoin} from 'react-icons/bs'
import StoreHead from './StoreHead/StoreHead'
import StoreComponent from './StoreComponent/StoreComponent'
import swal from 'sweetalert2'
import {useNavigate} from 'react-router-dom'

function CashPayView(){

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
        <div className='cashPayView'>
            <ReturnButtonsComponent back="/Payment/Select"/>
            <p className='titleCashPayment'>Cash Payment</p>
            <BsCashCoin className='iconCash'/>
            <p className='storeSelection'>Select the store to go pay tickets</p>
            <section className='paymentStore'>
                <StoreHead/>
                <section className='storeList'>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                    <StoreComponent name="TicketsYa! Store goodnees" site="Colonia Zacamil, Lote #2"/>
                </section>
            </section>
            <p className='amountInput'>Insert the amount to pay</p>
            <label>Amount:</label>
            <input type="text" placeholder='Ej:$15.00'/>
            <p className='totalPayParraph'>Total to Pay: $00.00</p>
            <button className='buttonPayAmount' onClick={onClickHandler}>Pay</button>
        </div>
    )
}

export default CashPayView