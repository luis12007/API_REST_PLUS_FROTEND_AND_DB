import './BoardEvents.css';
import EventComponent from './EventComponent/EventComponent';
import { useEffect, useState } from 'react';
import ServicesAssign from '../../../../../Services/AssignmentService';
import ServicesEvent from '../../../../../Services/EventService';
import ServicesUser from '../../../../../Services/UserService';

function BoardEvents() {
    const [events, setEvents] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = localStorage.getItem('token');
                const user = await ServicesUser.Owmail(token);

                const assignments = await ServicesAssign.GetAllAssignByUserId(token, user.userid);
                console.log(assignments);
                const eventPromises = assignments.map(async (assignment) => {
                    const eventId = assignment.showEventDTO.id;
                    const event = await ServicesEvent.GetEventById(token, eventId);
                    const sponsor = await ServicesEvent.GetSponsorByEventId(token, eventId);
                    const place = sponsor.length > 0 ? sponsor[0].name : event.place;

                    return {
                        id: event.id,
                        date: event.date,
                        time: event.hour,
                        place: place,
                        img: event.image
                    };
                });

                const eventData = await Promise.all(eventPromises);
                setEvents(eventData);
            } catch (error) {
                console.error('Error al obtener los datos de los eventos:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div className="board-events">
            {events.map((event) => (
                <EventComponent
                    key={event.id}
                    date={event.date}
                    time={event.time}
                    place={event.place}
                    img={event.img}
                />
            ))}
        </div>
    );
}

export default BoardEvents;
