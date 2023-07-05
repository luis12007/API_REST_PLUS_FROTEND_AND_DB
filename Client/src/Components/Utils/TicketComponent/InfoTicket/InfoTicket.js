import Info from './Info/Info'
import './InfoTicket.css'

function InfoTicket({ quantity, status }) {

    return(
        <div className='info-ticket'>
            <Info title="Cantidad" description={`x ${quantity}`} className="1"/>
            <Info title="Estado" description={status} className="2"/>
        </div>
    )
}

export default InfoTicket;
