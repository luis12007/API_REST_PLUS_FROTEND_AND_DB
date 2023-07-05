import './HeadComponent.css'

function HeadComponent(){
    return(
        <div className='headComponent'>
            <p className='classHead'>Type</p>
            <p className='priceHead'>Price</p>
            <p className='seatsHead'>Number of seats</p>
            <p className='areasHead'>Total Areas Seats</p>
        </div>
    )
}

export default HeadComponent