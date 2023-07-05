import './UserEventsCreated.css'
import Searcher from '../../../Utils/Searcher/Searcher'
import Board from '../../../Utils/Board/Board'
import EventsCreatedContainer from './EventsCreatedContainer/EventsCreatedContainer'

function UserEventsCreated(){
    return(
        <div className='events-created'>
            <Board/>
            <Searcher text="events"/>
            <EventsCreatedContainer/>
        </div>
    )
}

export default UserEventsCreated