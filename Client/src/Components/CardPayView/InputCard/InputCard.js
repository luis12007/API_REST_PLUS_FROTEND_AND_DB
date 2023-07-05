import './InputCard.css'
import {TbAlertCircle} from 'react-icons/tb'

function InputCard(props){
    return(
        <div className='inputCardComponent'>
            <article className='sectionTitleInput'>
                <p>{props.text}</p>
                <TbAlertCircle className='iconAlert'/>
            </article>
            <input type="text" placeholder={props.ph}/>
        </div>
    )
}

export default InputCard