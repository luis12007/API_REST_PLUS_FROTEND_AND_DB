import React from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import UserRolTable from "../../Components/UserRolTable/UserRolTable";
import UserListTable from "../../Components/UserListTable/UserListTable";
import Exit from "../../Components/ExitSet/Exit";

function UserManange() {
    return (
        <div>
            <LogoHeader/>
            <AdminHeader/>
            <Separate/>
            <Exit></Exit>
            <UserListTable/>
            <UserRolTable/>
        </div>
    )
}

export default UserManange;