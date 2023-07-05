import './Searchers.css'
import filter from '../../../images/filtrar.png'
import search from '../../../images/lupa.png'

function Searcher(props){
    return (
        <div className='searcher'>
            <div className='searcher-container'>
                <p>Buscar {props.text}...</p>
                <div className='searcher-images'>
                    <img src={filter} alt="filtrar"/>
                    <img src={search} alt="buscar"/>
                </div>
            </div>
        </div>
    );
}

export default Searcher