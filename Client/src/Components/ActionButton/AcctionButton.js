import React from "react";
import './AcctionButton.css'



function AcctionButton(){
    return(
        <div className="editor-container">
            <table className='event-table'>
                <caption><h2>Listado de Eventos</h2></caption>
                <tr className='table-title'>
                    <th className='title'>Event</th>
                    <th className='title'>Name</th>
                    <th className='title'>Lugar</th>
                    <th className='title' >Fecha</th>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                </tr>
            </table>
            <div className="button-container">
                <button className='edit'>Edit</button>
                <button className='inactive'>Inactive</button>
                <button className='delete'>Delete</button>

            </div>   
        </div>     

    )
}

export default AcctionButton