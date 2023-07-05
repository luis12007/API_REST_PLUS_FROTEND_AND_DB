import React from 'react'

import dolarlogo from '../../../../images/signo-de-dolar.png'
import './PayButton.css'
import {useNavigate} from 'react-router-dom'
import swal from 'sweetalert2'

function PayButton (){

    const navigate = useNavigate();

    function handleClick(){
        swal.fire({
            title: 'Are you sure?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, save!'
          }).then((result) => {
            if (result.isConfirmed) {
              swal.fire(
                'Success!'
              )
              navigate('/Payment/Select')
            }
          })
    }

    return(
        <div className='pay-button-container'>
            <button className='pay-button' onClick={handleClick}>
                <h1 className='button-title'>Pay</h1>
                <img className='dolar-logo' src={dolarlogo} alt='dolar logo'/>   
            </button>
        </div>

    );


}

export default PayButton;