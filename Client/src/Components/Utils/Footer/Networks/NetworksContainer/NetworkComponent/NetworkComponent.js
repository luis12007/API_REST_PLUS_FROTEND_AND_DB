import React from 'react';
import './NetworkComponent.css';

function NetworkComponent({ route, name }) {
    const handleRedirect = () => {
        switch (name) {
            case 'facebook':
                window.location.href = 'https://facebook.com';
                break;
            case 'instagram':
                window.location.href = 'https://instagram.com';
                break;
            case 'whatsapp':
                window.location.href = 'https://whatsapp.com';
                break;
            case 'email':
                window.location.href = 'mailto:example@example.com';
                break;
            case 'snap':
                window.location.href = 'https://snapchat.com';
                break;
            case 'tiktok':
                window.location.href = 'https://tiktok.com';
                break;
            default:
                break;
        }
    };

    return (
        <div className="networkComponent" onClick={handleRedirect}>
            <img src={route} alt={name} />
        </div>
    );
}

export default NetworkComponent;
