import React from 'react';
import './UserListTable.css';
import editIcon from '../../images/editar.png';
import { useNavigate } from 'react-router-dom';

function UserListTable() {

    const navigate = useNavigate();

    const handler = async (e) => {
        e.preventDefault();
        navigate('/Admin/User')
    }


    return (
        <div className="user-list-table-container">
            <table className="user-table">
                <caption>
                    <h2>Administracion de usuarios</h2>
                </caption>
                <thead>
                    <tr>
                        <th>User</th>
                        <th>Name</th>
                        <th>Mail</th>
                        <th>Roles</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>kzapata</td>
                        <td>keiry zapata</td>
                        <td>keiry@gmail.com</td>
                        <td>administrador</td>
                        <td>
                            <button className="edit-button" type="button" onClick={handler}>
                                <img className="edit" src={editIcon} alt="editar" />
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>kzapata</td>
                        <td>keiry zapata</td>
                        <td>keiry@gmail.com</td>
                        <td>administrador</td>
                        <td>
                            <button className="edit-button" type="button">
                                <img className="edit" src={editIcon} alt="editar" />
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>kzapata</td>
                        <td>keiry zapata</td>
                        <td>keiry@gmail.com</td>
                        <td>administrador</td>
                        <td>
                            <button className="edit-button" type="button">
                                <img className="edit" src={editIcon} alt="editar" />
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>kzapata</td>
                        <td>keiry zapata</td>
                        <td>keiry@gmail.com</td>
                        <td>administrador</td>
                        <td>
                            <button className="edit-button" type="button">
                                <img className="edit" src={editIcon} alt="editar" />
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>kzapata</td>
                        <td>keiry zapata</td>
                        <td>keiry@gmail.com</td>
                        <td>administrador</td>
                        <td>
                            <button className="edit-button" type="button">
                                <img className="edit" src={editIcon} alt="editar" />
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default UserListTable;
