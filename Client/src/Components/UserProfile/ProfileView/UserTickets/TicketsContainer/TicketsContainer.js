import TicketComponent from '../../../../Utils/TicketComponent/TicketComponent'
import './TicketsContainer.css'
import { useEffect, useState } from 'react';
import ServicesTicket from '../../../../../Services/TicketService';
import ServicesEvent from '../../../../../Services/EventService';

function TicketsContainer() {
    const [ticketData, setTicketData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = localStorage.getItem('token');
                const page = 0; // Define el número de página real
                const size = 20; // Define el tamaño de página real

                const response = await ServicesTicket.GettAllTicketPageByOwner(token, page, size);
                console.log('Datos de los tickets:', response);

                const tickets = response.content;
                const ticketDataWithSponsors = [];

                for (const ticket of tickets) {
                    const sponsor = await ServicesEvent.GetSponsorByEventId(token, ticket.event.id);
                    const place = sponsor.length > 0 ? sponsor[0].name : ticket.event.place;

                    let existingTicket = ticketDataWithSponsors.find(
                        (t) => t.event.id === ticket.event.id && t.tier === ticket.tier && t.active === ticket.active
                    );

                    if (existingTicket) {
                        existingTicket.quantity += 1; // Incrementar la cantidad si hay coincidencia
                    } else {
                        existingTicket = {
                            ...ticket,
                            event: {
                                ...ticket.event,
                                place: place
                            },
                            quantity: 1 // Establecer la cantidad en 1 si no hay coincidencia
                        };
                        ticketDataWithSponsors.push(existingTicket);
                    }
                }

                setTicketData(ticketDataWithSponsors);
            } catch (error) {
                console.error('Error al obtener los datos de los tickets:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div className="tickets-container">
            {ticketData.map((ticket) => (
                <TicketComponent
                    key={ticket.id}
                    id={ticket.id}
                    title={ticket.event.title}
                    date={ticket.event.date}
                    time={ticket.event.hour}
                    place={ticket.event.place}
                    quantity={ticket.quantity}
                    status={ticket.active ? 'disponible' : 'Inactivo'}
                    img={ticket.event.image}
                />
            ))}
        </div>
    )
}

export default TicketsContainer;
