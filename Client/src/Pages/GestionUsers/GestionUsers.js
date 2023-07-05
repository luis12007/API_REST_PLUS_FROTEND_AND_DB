import React from "react";


import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader"
import Searcher from "../../Components/Utils/Searcher/Searcher";
import IdentifierComponent from "../../Components/Utils/IdentifierComponent/IdentifierComponent";
import UserListTable from "../../Components/UserListTable/UserListTable"
import ShowPages from "../../Components/Utils/ShowPages/ShowPages";



function GestionUsers(){
  return (
    <div>
        <LogoHeader/>
        <AdminHeader/>
        <Searcher/>
        <IdentifierComponent/>
        <UserListTable/>
        <ShowPages/>
    </div>
  )
}

export default GestionUsers;