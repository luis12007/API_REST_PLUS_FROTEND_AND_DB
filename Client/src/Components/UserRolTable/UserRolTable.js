import React from "react";

import './UserRol.css'
import BackIcon from '..//../images/back.png'
import NextIcon from '..//../images/next.png'

function UserRolTable(){
    return(
        <div className="user-rol-container">
            <img className="back" src={BackIcon} alt="BackPages"/>
            <h4>Pages 1 - 10</h4>
            <img className="next" src={NextIcon} alt="NextPages"/>
        </div>

    )
}

export default UserRolTable