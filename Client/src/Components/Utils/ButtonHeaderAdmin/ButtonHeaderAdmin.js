import { useNavigate } from 'react-router-dom';
import './ButtonHeaderAdmin.css';

function ButtonHeader(props) {
    const navigate = useNavigate();

    const handleClick = () => {
        if (props.text === 'Manage Events') {

            navigate('/Admin/Events');
        } else if (props.text === 'Valid Tickets') {

            navigate('/Admin/QR');
        } else if (props.text === 'Users') {

            navigate('/Admin/Users');
        }
    };

    return (
        <button className='button-header' onClick={handleClick}>
            {props.text}
        </button>
    );
}

export default ButtonHeader;
