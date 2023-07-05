import './LocalitieComponent.css'

function LocalitieComponent(props){
    return (
        <div className='localitie-component'>
            <p className='name'>{props.name}</p>
            <p className='value'>{props.value}</p>
        </div>
    )
}

export default LocalitieComponent;