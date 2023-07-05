import './GenericButton.css'

function GenericButton(props){

    const classButton = "button-" + props.className;

    return <div className={classButton}>{props.children}</div>
    
}

export default GenericButton