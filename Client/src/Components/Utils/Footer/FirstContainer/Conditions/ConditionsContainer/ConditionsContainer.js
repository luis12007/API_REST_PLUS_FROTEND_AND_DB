import './ConditionsContainer.css'
import ConditionComponent from './ConditionComponent/ConditionComponent';

function ConditionsContainer(){
    return(
        <div className='conditions-container'>
            <ConditionComponent value="I accept the terms and conditions of use"/>
            <ConditionComponent value="I agree to receive commercial notifications from TicketsYA!"/>
        </div>
    );
}

export default ConditionsContainer;