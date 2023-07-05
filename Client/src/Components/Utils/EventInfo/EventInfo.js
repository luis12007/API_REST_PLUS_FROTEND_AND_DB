import './EventInfo.css'

function EventInfo(props){
    
    return (
        <div className='infoEventText'>
            <h3>{props.date}</h3>
            <p>Hora: {props.time}</p>
            <p>Lugar: {props.place}</p>
        </div>
    )
}

export default EventInfo