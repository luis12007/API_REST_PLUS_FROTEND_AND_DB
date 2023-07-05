import './ValorationComponent.css'
import star from '../../../../images/favorito.png'

function ValorationComponent(){
    return(
        <div className='valoration-component'>
            <h3>Stars</h3>
            <p>Note: The general feedback standard is 5 stars.</p>
            <section className='images'>
                <img src={star} alt="start-img"/>
                <img src={star} alt="start-img"/>
                <img src={star} alt="start-img"/>
                <img src={star} alt="start-img"/>
                <img src={star} alt="start-img"/>
            </section>
        </div>
    )
}

export default ValorationComponent;