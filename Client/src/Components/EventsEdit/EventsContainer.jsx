import React, { useEffect, useState } from 'react';
import EventTable from './EventTable';
import ServicesEvent from '../../Services/EventService';
import moment from 'moment';
import 'moment/locale/es';
import './EventsContainer.css';

function EventsContainer({ cat = '' }) {
  const [eventData, setEventData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = localStorage.getItem('token'); // Reemplaza "tu_token" con el token real
        const page = 0; // Define el número de página real
        const size = 10; // Define el tamaño de página real

        const response = await ServicesEvent.GetAllEventPageByCategory(token, cat, page, size);
        // Obtener la ubicación para cada evento
        const eventsWithLocation = await Promise.all(
          response.content.map(async (event) => {
            const location = await ServicesEvent.GetSponsorByEventId(token, event.id);

            const eventDate = new Date(event.date);
            const formattedDate = `${eventDate.getDate()}/${eventDate.getMonth() + 1}/${eventDate.getFullYear()}`;
            const eventTime = event.date.split('T')[1].substring(0, 5);
            const formattedTime = `${eventTime} ${event.hour.includes('AM') ? 'a.m.' : 'p.m.'}`;

            return {
              ...event,
              place: location[0].name,
              date: formattedDate,
              time: formattedTime,
            };
          })
        );

        const currentDate = moment().format('D/M/YYYY');
        const oneMonthAhead = moment().add(1, 'month');

        const filteredEvents = eventsWithLocation.filter((event) => {
          const eventDate = moment(event.date, 'D/M/YYYY');
          return eventDate.isSameOrAfter(oneMonthAhead) && eventDate.isSameOrAfter(currentDate);
        });

        setEventData(filteredEvents);
      } catch (error) {
        console.error('Error al obtener los datos de los eventos:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="events-container">
      <EventTable eventData={eventData} />
    </div>
  );
}

export default EventsContainer;
