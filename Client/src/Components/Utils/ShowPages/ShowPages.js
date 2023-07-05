import React from "react";

import './ShowPages.css'
import BackIcon from '../../../images/back.png'
import NextIcon from '../../../images/next.png'

function ShowPages(){
    return(
        <div className="pages">
            <img className="back" src={BackIcon} alt="BackPages"/>
            <h4>Pages 1 - 10</h4>
            <img className="next" src={NextIcon} alt="NextPages"/>
        </div>

    )
}

export default ShowPages