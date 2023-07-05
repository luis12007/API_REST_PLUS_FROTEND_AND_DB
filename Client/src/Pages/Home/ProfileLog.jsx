import React from "react";
import ProfileView from "../../Components/UserProfile/ProfileView/ProfileView";
import Header from "../../Components/Utils/Header/Header";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import UserAvatar from "../../Components/Utils/UserAvatar/UserAvatar"
import Separate from "../../Components/Utils/Separate/Separate";

function ProfileLog(){
  return (
    <div>
        <LogoHeader/>
        <Header/>
        <Separate/>
        <UserAvatar/>
        <ProfileView/>
    </div>
  )
}

export default ProfileLog;