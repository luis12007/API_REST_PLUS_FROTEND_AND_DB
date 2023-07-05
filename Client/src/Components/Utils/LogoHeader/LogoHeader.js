import './LogoHeader.css'
import Logo from '../Logo/Logo';

function LogoHeader(){
    return (
        <div className="logo-header">
            <section className="section-one"></section>
            <section className="section-two"></section>
            <section className="section-three"></section>
            <Logo/> 
        </div>
    )
}

export default LogoHeader;