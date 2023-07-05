import EventCreatedComponent from './EventCreatedComponent/EventCreatedComponent'
import './EventsCreatedContainer.css'
import LastEventsCreated from './LastEventsCreated/LastEventsCreated'

function EventsCreatedContainer(){
    return(
        <div className="events-created-container">
            <EventCreatedComponent/>
            <LastEventsCreated/>
        </div>
    )
}

export default EventsCreatedContainer