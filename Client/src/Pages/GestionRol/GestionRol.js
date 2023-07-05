import React from "react";


import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader"
import Searcher from "../../Components/Utils/Searcher/Searcher";
import IdentifierComponent from "../../Components/Utils/IdentifierComponent/IdentifierComponent";
import RolAsignacionTable from "../../Components/RolAsignacionTable/RolAsignacionTable"





function GestionRolTable(){
  return (
    <div>
        <LogoHeader/>
        <AdminHeader/>
        <Searcher/>
        <IdentifierComponent/>
        <RolAsignacionTable/>
    </div>
  )
}

export default GestionRolTable;