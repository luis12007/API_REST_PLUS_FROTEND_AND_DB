import './Logo.css'
import logo from '../../../images/billete-de-avion.png'

function Logo(){
    return (
        <div className='logo-div'>
            <div className='logo'>
                <img src={logo} alt='logo'/>
                <h2>TicketsYA!</h2>
            </div>
        </div>
    );
}

export default Logo;