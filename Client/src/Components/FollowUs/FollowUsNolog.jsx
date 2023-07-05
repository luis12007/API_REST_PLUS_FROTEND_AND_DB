import React from 'react';
import './FollowUsNolog.css';
import FB from '../../images/facebook.png'
import instagram from '../../images/instagram.png'
import tiktok from '../../images/tik-tok.png'

const FollowUsNolog = () => {
  return (
    <div className="redes-sociales">
      <div className="follow-us">
        <h2>Follow Us</h2>
        <div className="social-icons">
          <div className="icon">
            <img src={FB}  alt="Facebook" />
            <p>@TicketYA!Sv</p>
          </div>
          <div className="icon">
            <img src={tiktok} alt="tiktok" />
            <p>@TicketYA!Sv</p>
          </div>
          <div className="icon">
            <img src={instagram} alt="Instagram" />
            <p>@TicketYA!Sv</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FollowUsNolog;
