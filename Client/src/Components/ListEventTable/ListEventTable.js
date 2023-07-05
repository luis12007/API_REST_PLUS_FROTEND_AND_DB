import React from "react";
import './ListEventTable.css';
import edit from '..//../images/editar.png'

function UserListTable(){
    return(
        <div className='event-list-table-container'>
            <table className='event-table'>
                <caption><h2>Listado de Eventos</h2></caption>
                <tr className='table-title'>
                    <th className='title'>Event</th>
                    <th className='title'>Name</th>
                    <th className='title'>Lugar</th>
                    <th className='title' >Fecha</th>
                    <th className='title'>Action</th>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                <tr>
                    <td>001-001</td>
                    <td>Guns and Roses Concert</td>
                    <td>Magico Gonzales Stadium</td>
                    <td>10/12/2023 08:00pm</td>
                    <td><button className="edit-button" type="button"> <img className='edit' src={edit} alt="editar"/></button></td>
                </tr>
                
            </table>
            
        </div>
    )
}

export default UserListTable