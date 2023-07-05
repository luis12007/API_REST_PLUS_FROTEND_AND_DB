import React from 'react';
import Events from '../../Components/UserHomeView/Main/EventsContainer/EventsContainer';
import Header from '../../Components/Utils/Header/Header';
import Footer from '../../Components/Utils/Footer/Footer';
import LogoHeader from '../../Components/Utils/LogoHeader/LogoHeader';
import UnderFooter from '../../Components/Utils/UnderFooter/UnderFooter';
import Searcher from '../../Components/Utils/Searcher/Searcher';
import IdentifierComponent from '../../Components/Utils/IdentifierComponent/IdentifierComponent';
import FollowUsNologCompo from '../../Components/FollowUs/FollowUsNolog';
import Separate from '../../Components/Utils/Separate/Separate';

export default function FollowUsNolog() {


    return (
        <div>
            <LogoHeader/>
            <Header></Header>
            <Separate/>
            <IdentifierComponent title="Siguenos en nuestras redes!"/>
            <FollowUsNologCompo></FollowUsNologCompo>
            <Footer></Footer>
            <UnderFooter/>
        </div>
    );
}