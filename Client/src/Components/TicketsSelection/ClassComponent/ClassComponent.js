import './ClassComponent.css'
import {AiOutlineMinusCircle} from 'react-icons/ai'
import {AiOutlinePlusCircle} from 'react-icons/ai'

function ClassComponent(props){
    return (
        <div className='classComponent'>
            <p className='typeClass'>{props.type}</p>
            <p className='priceClass'>{props.price}</p>
            <section className='seatsOfClass'>
                <AiOutlineMinusCircle className='minusIcon'/>
                <p className='counterSeats'>####</p>
                <AiOutlinePlusCircle className='plusIcon'/>
            </section>
            <p className='areasClass'>####</p>
        </div>
    )
}

export default ClassComponent