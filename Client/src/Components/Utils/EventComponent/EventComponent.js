import './EventComponent.css'
import EventInfo from '../EventInfo/EventInfo';
import {useNavigate} from 'react-router-dom'

function EventComponent(props){
  const navigate = useNavigate();
  
   function handleClick(){
        navigate('/Event/Name/Buy')
    }
  
    return(
        <div className="eventComponentRender" style={{ backgroundImage: `url(${props.bg})`, backgroundSize: 'cover' }} onClick={handleClick}>
            <div className='infoEventRender' >
                <EventInfo date={props.date} time={props.time} place={props.place} />
                <button className='btnShowEventDetails'>Show more</button>
            </div>
        </div>
    );
}

export default EventComponent;
