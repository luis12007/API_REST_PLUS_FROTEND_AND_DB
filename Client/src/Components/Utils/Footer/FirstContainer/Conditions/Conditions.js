import Logo from '../../../Logo/Logo'
import './Conditions.css';
import ConditionsContainer from './ConditionsContainer/ConditionsContainer';

function Conditions(){
    return(
        <div className='footer-conditions'>
            <ConditionsContainer/>
            <Logo/>
        </div>
    );
}

export default Conditions;