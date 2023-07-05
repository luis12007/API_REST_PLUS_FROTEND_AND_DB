import React from 'react';
import Events from '../../../Components/UserHomeView/Main/EventsContainer/EventsContainer';
import HeaderNoLog from '../../../Components/Utils/HeaderWithoutLogin/HeaderWithoutLogin';
import Footer from '../../../Components/Utils/Footer/Footer';
import LogoHeader from '../../../Components/Utils/LogoHeader/LogoHeader';
import UnderFooter from '../../../Components/Utils/UnderFooter/UnderFooter';
import Searcher from '../../../Components/Utils/Searcher/Searcher';
import IdentifierComponent from '../../../Components/Utils/IdentifierComponent/IdentifierComponent';
import AboutUs from '../../../Components/AboutUs/AboutUs';
import Separate from '../../../Components/Utils/Separate/Separate';

export default function AboutUsNoLog() {


    return (
        <div>
            <LogoHeader/>
            <HeaderNoLog></HeaderNoLog>
            <Separate/>
            <IdentifierComponent title="Sobre nosotros"/>
            <AboutUs></AboutUs>
            <Footer></Footer>
        </div>
    );
}