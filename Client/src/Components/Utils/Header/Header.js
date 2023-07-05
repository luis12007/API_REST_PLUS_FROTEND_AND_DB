import ButtonHeader from '../ButtonHeader/ButtonHeader'
import ButtonProfile from '../ButtonProfile/ButtonProfile'
import './Header.css'

function Header(){

    return(
        <div className='header'>
            <ButtonHeader text='Home' route="/HomeLog"/>
            <ButtonHeader text='Eventos' route = "/EventsLog"/>
            <ButtonHeader text='Nosotros' route="/AboutUsLog"/>
            <ButtonHeader text='Media' route="/FollowUsLog"/>
            <ButtonProfile text='Perfil' route="/Profile/Tickets"/>
        </div>
    )
}

export default Header