import './EventTicket.css'
import Logo from '../Utils/Logo/Logo'
import ReturnButtonsComponent from '../Utils/ReturnButtonsComponent/ReturnButtonsComponent';
import Footer from '../Utils/Footer/Footer';
import EventMediaComponent from './EventMediaComponent/EventMediaComponent';
import DataEventComponent from './DataEventComponent/DataEventComponent';
import Banner from '../../images/banner.jpg'

function EventTicket(){
    return (
        <div className='event-ticket-component'>
            <div className='header-view-component'>
                <ReturnButtonsComponent back="/HomeLog"/>
            </div>
            <section className='img-event-ticket'>
                <img className='imgnew' src={Banner} alt="event-banner"/>
            </section>
            <section className='info-ticket-buys'>
                <article className='info-to-buy-tickets'>
                    <section className='data-of-event'>
                        <p className='title'>Event information</p>
                        <section className='event-data'>
                            <DataEventComponent title="Date" value="09 de Mayo"/>
                            <DataEventComponent title="Place" value="Select Place"/>
                            <DataEventComponent title="Hour" value="00:00 p.m."/>
                        </section>
                    </section>
                    <section className='localities-section'>
                        <EventMediaComponent/>
                    </section>
                </article>
            </section>
            <Footer/>
        </div>
    )
}

export default EventTicket;