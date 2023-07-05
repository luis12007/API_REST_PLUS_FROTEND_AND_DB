import React from "react";
import Footer from '../../Components/Utils/Footer/Footer'
import Header from '../../Components/Utils/Header/Header'
import Main from '../../Components/UserHomeView/Main/EventsContainer/EventsContainer'
import LogoHeader from '../../Components/Utils/LogoHeader/LogoHeader'
import Searcher from '../../Components/Utils/Searcher/Searcher'
import IdentifierComponent from '../../Components/Utils/IdentifierComponent/IdentifierComponent';

function EventsHome() {
  return (
    <div>
        <LogoHeader/>
            <Header/>
            <Searcher text="events"/>
            <IdentifierComponent title="Upcoming Events"/>
            <Main/>
            <Footer/>
    </div>
  );
}

export default EventsHome;