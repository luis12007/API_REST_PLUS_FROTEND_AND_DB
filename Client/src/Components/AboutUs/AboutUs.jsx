import React from 'react';
import './AboutUs.css';

const AboutUs = () => {
    return (
        <div className="about-us">
            <div className="card">
                <img className="card-image" src="https://img.freepik.com/vector-gratis/bend-teniendo-concierto-al-aire-libre_23-2148664579.jpg?w=1380&t=st=1688504527~exp=1688505127~hmac=63e2647e4fefad7180f12352a62a484db4bb88600003391b187d0c79a62fc8fd" alt="about us" />
                <div className="card-content">
                    <h2 className="card-title">About Us</h2>
                    <p className="card-text">
                        Proporcionamos una plataforma de venta de entradas en línea donde los usuarios pueden comprar boletos para una variedad de eventos, como conciertos, festivales, obras de teatro, eventos deportivos y mucho más. Nuestra plataforma es fácil de usar y brinda a los clientes una experiencia de compra rápida y segura.
                    </p>
                </div>
            </div>

            <div className="card">
                <div className="card-content">
                    <h2 className="card-title">Visión</h2>
                    <p className="card-text">
                        Como empresa, nos enorgullece ser líderes en la industria de venta de tickets, y nuestra visión es convertirnos en el destino preferido para aquellos que buscan acceder a eventos en todo el mundo. Buscamos constantemente nuevas oportunidades y tecnologías innovadoras para mejorar la experiencia de nuestros clientes. Queremos ser reconocidos por nuestra excelencia en el servicio al cliente, la facilidad de uso de nuestra plataforma y la diversidad de eventos que ofrecemos.
                    </p>
                </div>
            </div>

            <div className="card">
                <div className="card-content">
                    <h2 className="card-title">Misión</h2>
                    <p className="card-text">
                        Nuestra misión es brindar a nuestros clientes una experiencia de compra de tickets simple, conveniente y confiable. Nos esforzamos por conectar a las personas con sus eventos favoritos, ya sea un concierto emocionante, un partido de fútbol importante o una obra de teatro inspiradora. Trabajamos arduamente para garantizar la satisfacción de nuestros clientes al ofrecer un servicio eficiente, una amplia selección de eventos y precios competitivos.
                    </p>
                </div>
            </div>

            <div className="card">
                <div className="card-content">
                    <h2 className="card-title">Creador</h2>
                    <p className="card-text">
                        Ian McKellen, el visionario fundador de nuestra empresa de venta de tickets, es un apasionado de la industria del entretenimiento. Con una amplia experiencia en el sector, Ian ha dedicado su carrera a facilitar el acceso de las personas a eventos culturales, deportivos y artísticos. Su visión emprendedora y su profundo conocimiento de la industria han sido la base para el éxito de nuestra empresa, que se estableció en 2012.
                    </p>
                </div>
            </div>
        </div>
    );
};

export default AboutUs;
