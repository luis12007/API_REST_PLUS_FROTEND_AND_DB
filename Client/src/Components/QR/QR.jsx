import React, { useState } from 'react';
import './QR.css';

function ScanComponent() {
    const [isClicked, setIsClicked] = useState(false);

    const handleClick = () => {
        setIsClicked(true);
        setTimeout(() => {
            setIsClicked(false);
        }, 1000);
    };

    return (
        <div className="center-container">
            <div
                className={`scan-component ${isClicked ? 'clicked' : ''}`}
                onClick={handleClick}
            >
                <div className="scan-overlay"></div>
                <h1>Escanear</h1>
            </div>
        </div>
    );
}

export default ScanComponent;
