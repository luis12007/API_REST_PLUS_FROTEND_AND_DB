import './DataEventComponent.css'

function DataEventComponent(props){
    return(
        <div className='dataComponent'>
            <section className='infoData'>
                <p className='titleData'>{props.title}</p>
                <p className='valueData'>{props.value}</p>
                <p className='lineData'></p>
            </section>
        </div>
    )
}

export default DataEventComponent;