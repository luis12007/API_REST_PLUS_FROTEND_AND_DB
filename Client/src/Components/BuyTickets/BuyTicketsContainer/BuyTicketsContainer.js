import React from "react";

import backarrow from '../../../images/flecha-izquierda.png'
import userlogo from '../../../images/usuario.png'
import './BuyTicketsContainer.css'
import PayButton from './PayButton/PayButton'
import TicketsTable from '../BuyTicketsContainer/TicketsTable/TicketsTable'
import TicketsYaButton from '../../Utils/TicketsYaButton/TicketsYaButton'
import ReturnButtonsComponent from "../../Utils/ReturnButtonsComponent/ReturnButtonsComponent";

function BuyTicketsContainer(){
    return(
        <div className="buy-tickets-container">
            <ReturnButtonsComponent back="/Event/Select"/>
            <div className="tickets-ya-button">
                <TicketsYaButton/>
            </div>
            <div className="tickets-table">
                <TicketsTable/>
            </div>
            <div className="paybutton">
                <PayButton/>
            </div>
        </div>

    );

    
}
export default BuyTicketsContainer