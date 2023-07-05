import './EventComponent.css';
import EventInfo from '../../../../../Utils/EventInfo/EventInfo';

function EventComponent({ date, time, place, img }) {
    // Obtener solo la fecha en formato "YYYY-MM-DD"
    const formattedDate = date.split('T')[0];

    return (
        <div className='event-component' style={{ backgroundImage: `url(${img})`, backgroundSize: 'cover' }}>
            <div className="modal-event">
                <button className="btn-modal-add">+</button>
                <p>Add new event to the list</p>
            </div>
            <div className='info-event'>
                <EventInfo date={formattedDate} time={time} place={place} />
                <button className='btn-show'>Show more</button>
            </div>
        </div>
    );
}

export default EventComponent;
