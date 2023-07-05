import './CommonInputComponent.css'

function CommonInputComponent(props){
    return(
        <div className='common-input-component'>
            <h3>{props.title}</h3>
            <p>{props.note}</p>
            <input type='text' placeholder={props.placeholder}/>
        </div>
    )
}

export default CommonInputComponent;