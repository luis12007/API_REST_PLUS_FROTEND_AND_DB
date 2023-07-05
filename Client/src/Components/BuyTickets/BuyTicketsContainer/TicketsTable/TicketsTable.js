import React from 'react'

import cart from '../../../../images/carrito-de-compras1.png'
import './TicketsTable.css'
import PayComponent from './PayComponent/PayComponent';
import TicketPayComponent from './TicketPayComponent/TicketPayComponent';

function TicketsTable(){
  return (
    <div className='ticketsTableToPay'>
      <section className='descriptionTable'>
        <img src={cart} alt="buysCart"/>
        <p>Your Tickets</p>
      </section>
      <PayComponent/>
      <section className='ticketListRendericed'>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
        <TicketPayComponent text="Platea: PL (No numerada) (Asiento no numerado)" 
        type="Platea" price="$50.00" surcharge="$10.00" total="$60.00"/>
      </section>
    </div>
  );   
}

export default TicketsTable