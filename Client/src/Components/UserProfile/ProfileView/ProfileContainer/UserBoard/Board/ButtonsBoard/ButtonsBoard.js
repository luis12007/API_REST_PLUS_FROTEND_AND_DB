import './ButtonsBoard.css'
import GenericButton from '../../../../../../Utils/GenericButton/GenericButton'

function ButtonsBoard(){
    return(
        <div className='buttons-board'>
            <GenericButton className="1">Events I will attend</GenericButton>
            <GenericButton className="2">My tickets</GenericButton>
            <GenericButton className="3">Events created</GenericButton>
        </div>
    )
}

export default ButtonsBoard