import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import Assignrol from "../../Components/RolAsignacionTable/RolAsignacionTable";

function AdminUser() {
    return (
        <div>
            <LogoHeader/>
            <AdminHeader/>
            <Separate/>
            <Assignrol/>
        </div>
    )
}

export default AdminUser;