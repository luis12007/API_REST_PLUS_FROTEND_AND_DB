import React from "react";

import ticket from '../../../images/billete-de-avion.png'
import  './TicketsYaButton.css'


function TicketsYaButton(){
    return(
        <div className="tickets-ya-container-button">
            <div className="tickets-ya-logo">
                <img className="ticket-logo" src={ticket} alt="ticket logo" />
                <h2 className="ticket-ya-title">TicketsYA!</h2>
            </div>
        </div>
    );

}
export default TicketsYaButton