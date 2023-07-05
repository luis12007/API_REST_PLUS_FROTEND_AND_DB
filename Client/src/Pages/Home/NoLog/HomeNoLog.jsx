import React from 'react';
import Events from '../../../Components/UserHomeView/Main/EventsContainer/EventsContainer';
import HeaderNoLog from '../../../Components/Utils/HeaderWithoutLogin/HeaderWithoutLogin';
import Footer from '../../../Components/Utils/Footer/Footer';
import LogoHeader from '../../../Components/Utils/LogoHeader/LogoHeader';
import Searcher from '../../../Components/Utils/Searcher/Searcher';
import IdentifierComponent from '../../../Components/Utils/IdentifierComponent/IdentifierComponent';

export default function HomeNoLog() {


    return (
        <div>
            <LogoHeader/>
            <HeaderNoLog></HeaderNoLog>
            <Searcher/>
            <IdentifierComponent title="Eventos proximos"/>
            <Events></Events>
            <Footer></Footer>
        </div>
    );
}