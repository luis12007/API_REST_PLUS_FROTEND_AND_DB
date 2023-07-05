import './ConditionComponent.css'

function ConditionComponent(props){
    return(
        <div className='condition-component'>
            <input type='checkbox'/>
            <p>{props.value}</p>
        </div>    
    );

}

export default ConditionComponent;