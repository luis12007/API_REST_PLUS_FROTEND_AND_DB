import React from "react";

import Ok from '../../../../images/ok.png'
import './OkPayment.css'

function OkPayment (){
    return (
        <div className="ok-payment-container">
            <img className="ok-logo-payment" src={Ok} alt="Ok logo"/>
            <h5>Your payment has been made successfuly</h5>
        </div>
    );

}

export default OkPayment