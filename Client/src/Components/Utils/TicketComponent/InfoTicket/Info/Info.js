import './Info.css'

function Info(props){

    const classInfo = "info"+props.className

    return(
        <div className={classInfo}>
            <section className='title-info'>{props.title}</section>
            <section className='description-info'>{props.description}</section>
        </div>
    )
}

export default Info