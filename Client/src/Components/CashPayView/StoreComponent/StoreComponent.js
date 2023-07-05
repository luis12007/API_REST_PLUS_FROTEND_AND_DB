import './StoreComponent.css'

function StoreComponent(props){
    return(
        <div className='storeComponent'>
            <p className='nameStore'>
                <input type="checkbox"/>
                {props.name}
            </p>
            <p className='siteStore'>{props.site}</p>
        </div>
    )
}

export default StoreComponent