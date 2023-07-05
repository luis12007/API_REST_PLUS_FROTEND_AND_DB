import './PriceComponent.css'

function PriceComponent(){
    return(
        <div className='price-component'>
            <h3 className='priceTitleComponent'>Price: </h3>
            <p>Note: You can specify the payment method (card o cash)</p>
            <p>Note: The type of payment must only be in national currency</p>
            <input type='text' placeholder='Ej:$99.99' className='input-price'/>
        </div>
    )
}

export default PriceComponent