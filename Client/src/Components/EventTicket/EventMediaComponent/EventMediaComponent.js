import ButtonMediaComponent from './ButtonMediaComponent/ButtonMediaComponent';
import './EventMediaComponent.css'
import LocalitiesInfoComponent from './LocalitiesInfoComponent/LocalitiesInfoComponent';

function EventMediaComponent(){
    return (
        <div className='event-media-component'>
            <section className='btns-media-component'>
                <ButtonMediaComponent child="Ticket"/>
                <ButtonMediaComponent child="Sound/Media"/>
            </section>
            <LocalitiesInfoComponent/>
        </div>
    )
}

export default EventMediaComponent;