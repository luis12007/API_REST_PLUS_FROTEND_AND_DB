import Comment from './Comment/Comment'
import Conditions from './Conditions/Conditions'
import './FirstContainer.css'

function FirstContainer(){
    return(
        <div className='firstContainer'>
            <Comment/>
            <Conditions/>
        </div>
    )
}

export default FirstContainer