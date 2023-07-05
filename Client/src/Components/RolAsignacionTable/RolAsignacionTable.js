import React from "react";
import './RolAsignacionTable.css';
import { useNavigate } from "react-router-dom";

function RolAsignacionTable() {
    const navigate = useNavigate();

    const handleCancel = () => {
        // Lógica para manejar el botón "Cancel"
        navigate('/Admin/Users')
    };


    const handleAccept = () => {
        // Lógica para manejar el botón "Accept"
        navigate('/Admin/Users')
    };

    return (
        <div className="rol-asignacion-container">
            <button className="user-name-rol-button">Keiry Zapata</button>
            <table className="asignar-rol">
                <thead>
                    <tr>
                        <th>User Roles</th>
                        <th>Add Roles</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Administrador</td>
                        <td>
                            <input type="checkbox" id="checkbox1" />
                            <label htmlFor="checkbox1"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>Coordinador</td>
                        <td>
                            <input type="checkbox" id="checkbox2" />
                            <label htmlFor="checkbox2"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>Staff</td>
                        <td>
                            <input type="checkbox" id="checkbox3" />
                            <label htmlFor="checkbox3"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>Cliente</td>
                        <td>
                            <input type="checkbox" id="checkbox4" />
                            <label htmlFor="checkbox4"></label>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div className="button-container">
                <button className="accept" onClick={handleAccept}>Accept</button>
                <button className="cancel" onClick={handleCancel}>Cancel</button>
            </div>
        </div>
    );
}

export default RolAsignacionTable;
