import React from 'react';
import Events from '../../../Components/UserHomeView/Main/EventsContainer/EventsContainer';
import HeaderNoLog from '../../../Components/Utils/HeaderWithoutLogin/HeaderWithoutLogin';
import Footer from '../../../Components/Utils/Footer/Footer';
import LogoHeader from '../../../Components/Utils/LogoHeader/LogoHeader';
import UnderFooter from '../../../Components/Utils/UnderFooter/UnderFooter';
import Searcher from '../../../Components/Utils/Searcher/Searcher';
import IdentifierComponent from '../../../Components/Utils/IdentifierComponent/IdentifierComponent';
import EventesActually from '../../../Components/UserHomeView/Main/EventsContainer/EventsContainerAC';

export default function EventsNoLog() {


    return (
        <div>
            <LogoHeader/>
            <HeaderNoLog></HeaderNoLog>
            <Searcher/>
            <IdentifierComponent title="Eventos Actuales"/>
            <EventesActually></EventesActually>
            <Footer></Footer>
            <UnderFooter/>
        </div>
    );
}