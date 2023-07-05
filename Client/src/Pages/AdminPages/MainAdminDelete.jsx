import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import CardEvent from "../../Components/AdminEvent/AdminEvent";
import EventsContainer from "../../Components/EventsDelete/EventsContainer";

function MainAdmin() {
    return (
        <div>
            <LogoHeader/>
            <AdminHeader/>
            <Separate/>
            <CardEvent title="Crear" action="Acción de Crear" />
            <EventsContainer/> 
        </div>
    )
}

export default MainAdmin;