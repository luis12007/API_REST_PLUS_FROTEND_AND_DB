import ButtonHeader from '..//Utils/ButtonHeaderAdmin/ButtonHeaderAdmin'
import './AdminHeader.css'

function Header(){

    return(
        <div className='header'>
            <ButtonHeader text='Manage Events'/>
            <ButtonHeader text='Valid Tickets' />
            <ButtonHeader text='Users' />
        </div>
    )
}

export default Header