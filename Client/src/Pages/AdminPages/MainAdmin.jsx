import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import CardEvent from "../../Components/AdminEvent/AdminEvent";
import Exit from "../../Components/ExitSet/Exit";


function MainAdmin() {
    return (
        <div>
            <LogoHeader/>
            <AdminHeader/>
            <Separate/>
            <Exit></Exit>
            <CardEvent title="Crear" action="Acción de Crear" />
        </div>
    )
}

export default MainAdmin;