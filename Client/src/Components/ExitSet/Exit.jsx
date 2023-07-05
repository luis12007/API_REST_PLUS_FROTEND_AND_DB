import React from "react";
import src from "../../images/Gear.png";
import { useNavigate } from 'react-router-dom';
import "./Exit.css";

function ExitButton() {
    const navigate = useNavigate();
    const handleClick = () => {
            navigate("/HomeLog")
    };

    return (
        <button className="exit-button" onClick={handleClick}>
            <img src={src} />
        </button>
    );
}

export default ExitButton;
