import React from 'react';
import { useNavigate } from 'react-router-dom';
import './AdminEvent.css';

function Card({ title, action, color, path }) {
    const cardStyle = {
        backgroundColor: color,
        borderRadius: '10px',
        border: `2px solid ${color}`,
        opacity: 0.9,
    };

    const navigate = useNavigate();

    const handleClick = () => {
        if (title === 'Crear') {
            navigate("/Admin/Events/Create");
        } else if (title === 'Editar') {
            navigate("/Admin/Events/Edit");
        } else if (title === 'Panico') {
            navigate("/Admin/Events/Delete");
        }
    };

    return (
        <div className="card" style={cardStyle} onClick={handleClick}>
            <h2 className="card-title">{title}</h2>
            <p className="card-action"></p>
        </div>
    );
}

function CardEvent() {
    return (
        <div className="container">
            <div className="column">
                <Card title="Crear" action="Acción de Crear" color="#4b93f7" path="/create" />
            </div>
            <div className="column">
                <Card title="Editar" action="Acción de Editar" color="#FFA07A" path="/edit" />
            </div>
            <div className="column">
                <Card title="Panico" action="Acción de Eliminar" color="#F9E79F" path="/delete" />
            </div>
        </div>
    );
}

export default CardEvent;
