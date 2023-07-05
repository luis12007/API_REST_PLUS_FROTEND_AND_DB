import React, { useState } from 'react';
import './EventTable.css';
import { useNavigate } from 'react-router-dom';

function EventTable({ eventData }) {

  const [selectedEventId, setSelectedEventId] = useState('');
  const navigate = useNavigate();
  const handleRowClick = (eventId) => {
    navigate("/Admin/Events/Create");
    setSelectedEventId(eventId);
    
  };

  return (
    <table className="event-tableA">
      <thead>
        <tr>
            <th>Nombre</th>
          <th>Date</th>
          <th>Time</th>
          <th>Place</th>
        </tr>
      </thead>
      <tbody>
        {eventData.map((event) => (
          <tr
            key={event.id}
            className={selectedEventId === event.id ? 'selected' : ''}
            onClick={() => handleRowClick(event.id)}
          > 
            <td>{event.title}</td>
            <td>{event.date}</td>
            <td>{event.time}</td>
            <td>{event.place}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default EventTable;
