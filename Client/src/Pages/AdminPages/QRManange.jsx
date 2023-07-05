import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import QR from "../../Components/QR/QR";
import Exit from "../../Components/ExitSet/Exit";

function QRManange() {
    return (
        <div>
            <LogoHeader/>
            <AdminHeader/>
            <Separate/>
            <Exit></Exit>
            <QR></QR>
        </div>
    )
}

export default QRManange;