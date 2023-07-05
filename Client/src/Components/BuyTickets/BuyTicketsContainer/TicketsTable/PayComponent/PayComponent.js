import './PayComponent.css'
import deletelogo from '../../../../../images/eliminar.png'

function PayComponent(){
    return(
        <div className='payComponent'>
            <section className='selectionSection'>
                <article className='firstParraph'>
                    <input type='checkbox'/>
                    <p>Ticket</p>
                </article>
                <article className='secondParraph'>
                    <p>All</p>
                    <img src={deletelogo} alt="trashIcon"/>
                </article>
            </section>
            <p className='typePay'>Type</p>
            <p className='priceOfPay'>Price</p>
            <p className='surchargePay'>Surcharge</p>
            <p className='totalPay'>Total</p>
        </div>
    )
}

export default PayComponent;