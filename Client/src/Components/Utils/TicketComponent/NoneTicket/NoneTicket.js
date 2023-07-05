import './NoneTicket.css'
import Editar from '../../../../images/editar.png'

function NoneTicket(){
    return(
        <div className='modal-none-ticket'>
            <img src={Editar} alt="none-ticket"/>
            <p>None tickets yet!</p>
        </div>
    )
}

export default NoneTicket