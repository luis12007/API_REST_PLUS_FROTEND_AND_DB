import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import CardEvent from "../../Components/AdminEvent/AdminEvent";
import CreateEventView from '../../Pages/Home/CreateEventView';
import CreateSecondEventView from '../../Pages/Home/CreateSecondEventView';
import CreateThirdEventView from '../../Pages/Home/CreateThirdEventView';
import EventsContainer from "../../Components/EventsEdit/EventsContainer";

function CreateEvent() {
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

export default CreateEvent;