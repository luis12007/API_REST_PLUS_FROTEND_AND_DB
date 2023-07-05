import './PaymentComponent.css'

function PaymentComponent(){
    return(
        <div className='payment-component'>
            <h3>Payment Method:</h3>
            <section className='checkboxs'>
                <section className='input-box'>
                    <input type='checkbox' className='checkbox-one'/>
                    <p>Cash</p>
                </section>
                <section className='input-box'>
                    <input type='checkbox' className='checkbox-two'/>
                    <p>Card</p>
                </section>
                <section className='input-box'>
                    <input type='checkbox' className='checkbox-three'/>
                    <p>Both</p>
                </section>
            </section>
        </div>
    )
}

export default PaymentComponent