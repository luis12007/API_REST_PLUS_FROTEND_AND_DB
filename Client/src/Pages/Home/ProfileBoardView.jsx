import React from "react";
import Header from "../../Components/Utils/Header/Header";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import UserAvatar from "../../Components/Utils/UserAvatar/UserAvatar"
import Separate from "../../Components/Utils/Separate/Separate";
import ProfileBoard from "../../Components/UserProfile/ProfileBoard/ProfileBoard";

function ProfileBoardView(){
    return (
        <div>
            <LogoHeader/>
            <Header/>
            <Separate/>
            <UserAvatar/>
            <ProfileBoard/>
        </div>
    )
}

export default ProfileBoardView;