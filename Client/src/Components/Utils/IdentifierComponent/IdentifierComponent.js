import './IdentifierComponent.css'

function IdentifierComponent(props){
    return(
        <div className='identifier-component'>
            <h3>{props.title}</h3>
        </div>
    )
}

export default IdentifierComponent;