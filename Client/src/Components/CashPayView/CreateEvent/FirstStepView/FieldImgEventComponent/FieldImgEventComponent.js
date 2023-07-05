import './FieldImgEventComponent.css'
import alert from '../../../../images/signo-de-exclamacion.png'

function FieldImgEventComponent(){
    return(
        <div className='field-img-component'>
            <section className='field-img-description'>
                <section className='field-img-title'>
                    <h3>Add a promotional image of the event</h3>
                    <img src={alert } alt="alert-img"/>
                </section>
                <p>Note: When attaching the corresponding file, verify that it has the minimum length of dimensions: 1026x800 pixels</p>
            </section>
            <input type="image" alt="add image..."/>
        </div>
    )
}

export default FieldImgEventComponent