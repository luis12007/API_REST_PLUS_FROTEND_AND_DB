import './NoneEventsCreated.css'
import Editar from '../../../../../../../images/editar.png'

function NoneEventsCreated(){
    return(
        <div className='none-events-created-component'>
            <section className='modal-none-events'>
                <img src={Editar} alt="none-ticket"/>
                <p>None events created yet!</p>
            </section>
        </div>
    )
}

export default NoneEventsCreated