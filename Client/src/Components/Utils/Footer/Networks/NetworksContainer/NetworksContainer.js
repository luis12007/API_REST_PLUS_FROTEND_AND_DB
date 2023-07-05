import NetworkComponent from './NetworkComponent/NetworkComponent'
import './NetworksContainer.css'
import FB from '../../../../../images/facebook.png'
import instagram from '../../../../../images/instagram.png'
import whatsapp from '../../../../../images/whatsapp.png'
import email from '../../../../../images/correo-electronico.png'
import snap from '../../../../../images/snapchat.png'
import tiktok from '../../../../../images/tik-tok.png'

function NetworksContainer(){
    return(
        <div className='networkContainer'>
            <NetworkComponent route={FB} name="facebook"/>
            <NetworkComponent route={instagram} name="instagram"/>
            <NetworkComponent route={whatsapp} name="whatsapp"/>
            <NetworkComponent route={email} name="email"/>
            <NetworkComponent route={snap} name="snap"/>
            <NetworkComponent route={tiktok} name="tiktok"/>
        </div>
    )
}

export default NetworksContainer