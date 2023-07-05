import React from "react";
import ProfileTickets from '../../Components/UserProfile/ProfileTickets/ProfileTickets'
import Header from "../../Components/Utils/Header/Header";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import UserAvatar from "../../Components/Utils/UserAvatar/UserAvatar"
import Separate from "../../Components/Utils/Separate/Separate";

function ProfileTicketsView() {
    return (
        <div>
            <LogoHeader/>
            <Header/>
            <Separate/>
            <UserAvatar/>
            <ProfileTickets/>
        </div>
    )
}

export default ProfileTicketsView;