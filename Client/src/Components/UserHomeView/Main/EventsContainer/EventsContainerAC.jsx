import EventComponent from '../../../Utils/EventComponent/EventComponent';
import './EventsContainer.css';
import { useEffect, useState } from 'react';
import ServicesEvent from '../../../../Services/EventService';
import moment from 'moment';
import 'moment/locale/es'; // Importa la localización en español si lo deseas


function EventsActually({ cat = "" }) {
    const [eventData, setEventData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = localStorage.getItem('token');  // Reemplaza "tu_token" con el token real
                const page = 0; // Define el número de página real
                const size = 10; // Define el tamaño de página real

                const response = await ServicesEvent.GetAllEventPageByCategory(token, cat, page, size);
                // Obtener la ubicación para cada evento
                const eventsWithLocation = await Promise.all(response.content.map(async (event) => {
                    const location = await ServicesEvent.GetSponsorByEventId(token, event.id);

                    const eventDate = new Date(event.date);
                    const formattedDate = `${eventDate.getDate()}/${eventDate.getMonth() + 1}/${eventDate.getFullYear()}`;
                    const eventTime = event.date.split('T')[1].substring(0, 5);
                    const formattedTime = `${eventTime} ${event.hour.includes('AM') ? 'a.m.' : 'p.m.'}`;

                    return {
                        ...event,
                        place: location[0].name,
                        date: formattedDate,
                        time: formattedTime
                    };
                }));

                const currentDate = moment().format('D/M/YYYY');

                const filteredEvents = eventsWithLocation.filter((event) => {
                    const eventDate = moment(event.date, 'D/M/YYYY');
                    return eventDate.isSameOrAfter(currentDate);
                });

                setEventData(filteredEvents);
            } catch (error) {
                console.error('Error al obtener los datos de los eventos:', error);
            }
        };

        fetchData();
    }, []);
    // console.log(eventData);
    return (
        <div className='events-container'>
            {eventData.map((event) => (
                <EventComponent
                    id={event.id}
                    date={event.date}
                    time={event.time}
                    place={event.place}
                    bg={event.image}
                />
            ))}
        </div>
    );
}

export default EventsActually;